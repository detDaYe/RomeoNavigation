package org.lumenk.romeonavigation.finder;

import org.lumenk.romeonavigation.datastructures.RomeoQueue;
import org.lumenk.romeonavigation.datastructures.RomeoStack;
import org.lumenk.romeonavigation.routeinfo.RomeoRouteInformation;
import org.lumenk.romeonavigation.routeinfo.RouteInfo;
import org.lumenk.romeonavigation.objects.mapdata.DistanceRoadMapData;
import org.lumenk.romeonavigation.objects.roads.DistanceRoad;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;

import java.util.HashMap;
import java.util.Objects;

public class RomeoDijkstraRouteFinder {
    public static <WaypointIdType, RoadIdType> RomeoRouteInformation<WaypointIdType, RoadIdType> find(WaypointIdType departure, WaypointIdType arrival, DistanceRoadMapData<WaypointIdType, RoadIdType, ? extends DistanceRoad<WaypointIdType, RoadIdType>> map){
        HashMap<WaypointIdType, WaypointIdType> visitBefore = new HashMap<>();
        HashMap<WaypointIdType, RoadIdType> visitBeforeVia = new HashMap<>();
        //HashMap<WaypointIdType, Boolean> visited = new HashMap<>();
        HashMap<WaypointIdType, Double> distanceSum = new HashMap<>();

        visitBefore.put(departure, departure);
        distanceSum.put(departure, 0.0);
        //visited.put(departure, true);

        //Waypoint<WaypointIdType> added = Objects.requireNonNull(map.searchWaypointById(departure));
        OnRoadWaypoint<WaypointIdType, RoadIdType> added = Objects.requireNonNull(map.searchWaypointById(departure));
        RomeoQueue<Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType>> queue1, queue2;
        Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType> current, temp;

        queue1 = new RomeoQueue<>();
        queue2 = new RomeoQueue<>();

        current = null;
        temp = null;

        while(true){
            for (Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType> r : added.getConnectedRoads()) { //방금 막 추가한 노드에 대하여 연결된 도로를 가져오자
                //queue1.enqueue(r);
                //System.out.println("added road to q1");
                if(visitBefore.get(r.getTo().getId()) == null) //방문하지 않는 노드를 목적지로 하는 도로라면
                {
                    //System.out.println("added road... : " + r.getTo().getId());
                    //System.out.println("added road dep " + r.getFrom().getId() + " / arr " + r.getTo().getId());
                    queue1.enqueue(r); //큐에 추가함으로써 검토 대상에 추가한다.
                }
            }

            temp = null; current = null; //What the...
            double minValue = 99.0;//Double.MAX_VALUE / 2;
            while(queue1.getCount() > 0){ //큐에 있는 모든 검토 대상에 대하여 살펴보자.
                temp = Objects.requireNonNull(queue1.dequeue()); //큐에서 하나의 도로를 가져오자
                double d = Objects.requireNonNull(map.searchRoad(temp.getId(), temp.getFrom().getId(), temp.getTo().getId())).getDistance()
                        + distanceSum.get(temp.getFrom().getId()); //이 도로의 시점과 종점간의 거리에 출발지로부터 이 도로의 시점까지의 거리를 더해 보자

                if(d < minValue){ //만약 계산한 거리가 이전까지 계산한 최소 거리보다 작다면
                    if(current != null) //지금까지 최소 거리 도로라 생각하였던 도로를 추가할 일이 없으므로
                        queue2.enqueue(current);  //나중에 다시 검토하고
                    current = temp; //'최소거리 도로'의 후보를 갱신한다.
                    //System.out.println("current road updated.. dep " + current.getFrom().getId() + " arr " + current.getTo().getId());
                    //System.out.println("prev min : " + minValue + " new min : " + d);
                    minValue = d; //지금까지 찾은 최소 거리값을 갱신한다.
                    //System.out.println("min distance updated!");
                }else{ //딱히 거리가 작지 않다면
                    queue2.enqueue(temp); //나중에 다시 검토하는것으로 한다.
                }

            }

            //이제 current에는 거리의 합이 최소가 되는 도로가 있다.
            //System.out.println("Let's add the road");
            added = Objects.requireNonNull(current).getTo(); //방문 노드에 도로의 종점을 추가한다.
            //visited.put(current.getTo().getId(), true);
            //System.out.println("current load founded.. dep " + current.getFrom().getId() + " " + current.getTo().getId() + " sums " + minValue);
            //System.out.println("start point? " + current.getFrom().getId());
            //System.out.println("added waypoint " + added.getId());
            visitBefore.put(current.getTo().getId(), current.getFrom().getId()); //이 도로의 종점을 key로 하여 시점을 기록한다.
            visitBeforeVia.put(current.getTo().getId(), current.getId()); // 이 도로의 종점을 key로 하여 도로명을 기록한다.
            distanceSum.put(current.getTo().getId(), minValue); //또한 출발지에서 도로의 종점까지 누적된 거리를 기록한다

            if(current.getTo().getId().equals(arrival)) break; //만약 도로의 종점이 도착지라면 알고리즘을 종료한다

            while(queue2.getCount() > 0)queue1.enqueue(Objects.requireNonNull(queue2.dequeue())); //나중에 다시 검토하기로 한 도로를 재차 검토할 준비를 한다.
            if(queue1.getCount() == 0) return null; //만약 재차 검토할 수 있는 도로가 없다면, 방법이 없는 것으로 본다.
        }

        RomeoRouteInformation<WaypointIdType, RoadIdType> result = new RomeoRouteInformation<>();

        WaypointIdType w1, w2;
        RoadIdType via;
        double d;

        w2 = arrival; w1 = null;


        RomeoStack<RouteInfo<WaypointIdType, RoadIdType>> stack = new RomeoStack<>();
        while(w1 != departure){
            w1 = visitBefore.get(w2);
            via = visitBeforeVia.get(w2);
            d = distanceSum.get(w2);
            stack.push(new RouteInfo<>(w1, w2, via, d));

            w2 = w1;
        }

        RouteInfo<WaypointIdType, RoadIdType> info;
        while(stack.getCount() > 0){
            info = Objects.requireNonNull(stack.pop());
            result.addSegment(info.getFrom(), info.getTo(), info.getVia(), info.getSumOfWeight());
        }

        return result;

    }
}
