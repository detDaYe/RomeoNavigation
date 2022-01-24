package org.lumenk.romeonavigation.objects.waypoints;

import org.lumenk.romeonavigation.objects.roads.Road;

import java.util.ArrayList;

public abstract class OnRoadWaypoint<WaypointIdType,  RoadIdType> extends Waypoint<WaypointIdType>{

    public OnRoadWaypoint(WaypointIdType waypointIdType) {
        super(waypointIdType);
    }

    public abstract ArrayList<Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType>> getConnectedRoads();
}
