package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.roads.DistanceRoad;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.HashMap;

public class InMemoryRoadMapData<WaypointIdType, RoadIdType, RoadType  extends DistanceRoad<WaypointIdType, RoadIdType>> implements DistanceRoadMapData<WaypointIdType, RoadIdType, RoadType>{

    private final HashMap<Road<Waypoint<WaypointIdType>, WaypointIdType, RoadIdType>,
            RoadType> roadHashMap = new HashMap<>();

    private final HashMap<WaypointIdType, OnRoadWaypoint<WaypointIdType, RoadIdType>> waypointHashMap = new HashMap<>();

    @Override
    public RoadType searchRoad(RoadIdType id, WaypointIdType from, WaypointIdType to) {
        Road<Waypoint<WaypointIdType>, WaypointIdType, RoadIdType> keyObject
                = new Road<>(searchWaypointById(from),
                searchWaypointById(to), id);

        //return roadHashMap.getOrDefault();
        //return roadHashMap.getOrDefault(new Road<>)
        return roadHashMap.getOrDefault(keyObject, null);
    }

    @Override
    public OnRoadWaypoint<WaypointIdType, RoadIdType> searchWaypointById(WaypointIdType id) {
        return waypointHashMap.getOrDefault(id, null);
    }

    public void addWaypoint(OnRoadWaypoint<WaypointIdType, RoadIdType> waypoint){
        waypointHashMap.put(waypoint.getId(), waypoint);
    }

    public void addRoad(RoadType road){
        roadHashMap.put(new Road<>(road.getFrom(), road.getTo(), road.getId()), road);
    }
}
