package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.HashMap;

public class InMemoryRoadMapData<WaypointIdType, RoadIdType> implements RoadMapData<WaypointIdType, OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType, FixedDistanceRoad<WaypointIdType, RoadIdType>>{

    private final HashMap<Road<Waypoint<WaypointIdType>, WaypointIdType, RoadIdType>,
            FixedDistanceRoad<WaypointIdType, RoadIdType>> roadHashMap = new HashMap<>();

    private final HashMap<WaypointIdType, OnRoadWaypoint<WaypointIdType, RoadIdType>> waypointHashMap = new HashMap<>();

    @Override
    public FixedDistanceRoad<WaypointIdType, RoadIdType> searchRoad(RoadIdType id, WaypointIdType from, WaypointIdType to) {
        return null;
    }

    @Override
    public OnRoadWaypoint<WaypointIdType, RoadIdType> searchWaypointById(WaypointIdType id) {
        return null;
    }

    public void addWaypoint(OnRoadWaypoint<WaypointIdType, RoadIdType> waypoint){
        waypointHashMap.put(waypoint.getId(), waypoint);
    }

    public void addRoad(FixedDistanceRoad<WaypointIdType, RoadIdType> road){
        roadHashMap.put(new Road<>(road.getFrom(), road.getTo(), road.getId()), road);
    }
}
