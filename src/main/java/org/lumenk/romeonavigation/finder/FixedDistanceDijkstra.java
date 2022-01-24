package org.lumenk.romeonavigation.finder;

import org.jetbrains.annotations.NotNull;
import org.lumenk.romeonavigation.datastructures.RomeoQueue;
import org.lumenk.romeonavigation.objects.RouteInfo;
import org.lumenk.romeonavigation.objects.maps.RoadMap;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FixedDistanceDijkstra {
    public static <WaypointIdType,
            RoadIdType> ArrayList<RouteInfo<WaypointIdType, RoadIdType>> find(RoadMap<WaypointIdType,
            OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType, FixedDistanceRoad<WaypointIdType, RoadIdType>> map, WaypointIdType departureId, WaypointIdType arrivalId){

        HashMap<WaypointIdType, WaypointIdType> visitBefore = new HashMap<>();
        HashMap<WaypointIdType, Double> distanceSum = new HashMap<>();

        visitBefore.put(departureId, departureId);
        distanceSum.put(departureId, 0.0);

        OnRoadWaypoint<WaypointIdType, RoadIdType> added = Objects.requireNonNull(map.searchWaypointById(departureId));

        RomeoQueue<Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType>> queue1, queue2;
        //FixedDistanceRoad<OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType> current;
        FixedDistanceRoad<WaypointIdType, RoadIdType> current, temp;
        //Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType> temp;
        Double minValue = Double.MAX_VALUE;
        queue1 = new RomeoQueue<>();
        queue2 = new RomeoQueue<>();

        current = null;
        temp = null;
        while(true){


            added.getConnectedRoads().forEach(queue1::enqueue);


            while(queue1.getCount() > 0){
                temp = map.searchRoadById(Objects.requireNonNull(queue1.dequeue()).getId());
                Double d = temp.getDistance() + distanceSum.get(temp.getFrom().getId());
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
            distanceSum.put(current.getTo().getId(), current.getDistance());

            if(current.getTo().getId().equals(arrivalId))
                break;

            while(queue2.getCount() > 0)
                queue1.enqueue(Objects.requireNonNull(queue2.dequeue()));
            if(queue1.getCount() == 0)break;

        }

        return null;

    }
}
