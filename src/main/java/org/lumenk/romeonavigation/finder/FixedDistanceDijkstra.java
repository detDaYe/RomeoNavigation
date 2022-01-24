package org.lumenk.romeonavigation.finder;

import org.lumenk.romeonavigation.datastructures.RomeoQueue;
import org.lumenk.romeonavigation.datastructures.RomeoStack;
import org.lumenk.romeonavigation.objects.RouteInfo;
import org.lumenk.romeonavigation.objects.mapdata.RoadMapData;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FixedDistanceDijkstra {
    public static <WaypointIdType,
            RoadIdType> ArrayList<RouteInfo<WaypointIdType, RoadIdType>> find(RoadMapData<WaypointIdType,
                        OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType, FixedDistanceRoad<WaypointIdType, RoadIdType>> map, WaypointIdType departureId, WaypointIdType arrivalId){

        HashMap<WaypointIdType, WaypointIdType> visitBefore = new HashMap<>();
        HashMap<WaypointIdType, RoadIdType> visitBeforeVia = new HashMap<>();
        HashMap<WaypointIdType, Double> distanceSum = new HashMap<>();

        visitBefore.put(departureId, departureId);
        distanceSum.put(departureId, 0.0);

        OnRoadWaypoint<WaypointIdType, RoadIdType> added = Objects.requireNonNull(map.searchWaypointById(departureId));

        RomeoQueue<Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType>> queue1, queue2;
        //FixedDistanceRoad<OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType> current;
        FixedDistanceRoad<WaypointIdType, RoadIdType> current, temp;
        //Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType> temp;
        Double minValue = Double.MAX_VALUE / 2;
        queue1 = new RomeoQueue<>();
        queue2 = new RomeoQueue<>();

        current = null;
        temp = null;
        while(true){


            for (Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType> r : added.getConnectedRoads()) {
                if(visitBefore.get(r.getTo().getId()) == null) //방문하지 아니한 노드라는 의미
                    queue1.enqueue(r);
            }


            while(queue1.getCount() > 0){
                temp = map.searchRoad(Objects.requireNonNull(queue1.dequeue()).getId(), Objects.requireNonNull(temp).getFrom().getId(), temp.getTo().getId());
                double d = temp.getDistance() + distanceSum.get(temp.getFrom().getId());
                if(d < minValue){
                    if(current != null)
                        queue2.enqueue(current);
                    current = temp;
                    minValue = d;

                }else{
                    queue2.enqueue(temp);
                }
            }

            visitBefore.put(Objects.requireNonNull(current).getTo().getId(), current.getFrom().getId());
            visitBeforeVia.put(current.getTo().getId(), current.getId());
            distanceSum.put(current.getTo().getId(), current.getDistance());

            if(current.getTo().getId().equals(arrivalId))
                break;

            while(queue2.getCount() > 0)
                queue1.enqueue(Objects.requireNonNull(queue2.dequeue()));
            if(queue1.getCount() == 0) return null;

        }

        ArrayList<RouteInfo<WaypointIdType, RoadIdType>> result = new ArrayList<>();

        RomeoStack<RouteInfo<WaypointIdType, RoadIdType>> stack = new RomeoStack<>();

        WaypointIdType w1, w2;
        RoadIdType via;
        w1 = null;
        w2 = arrivalId;
        double d;
        while(w1 != departureId){
            w1 = visitBefore.get(w2);
            via = visitBeforeVia.get(w2);
            d = distanceSum.get(w2);
            stack.push(new RouteInfo<>(w1, w2, via, d));

            w2 = w1;
        }

        while(stack.getCount() > 0)
            result.add(stack.pop());
        return result;

    }
}
