package org.lumenk.romeonavigation.objects.waypoints;

import org.lumenk.romeonavigation.objects.roads.Road;

import java.util.ArrayList;

public class OnRoadWaypointInMemoryImpl<WayPointIdType, RoadIdType> extends OnRoadWaypoint<WayPointIdType, RoadIdType>{
    public OnRoadWaypointInMemoryImpl(WayPointIdType wayPointIdType) {
        super(wayPointIdType);
    }

    @Override
    public ArrayList<Road<OnRoadWaypoint<WayPointIdType, RoadIdType>, WayPointIdType, RoadIdType>> getConnectedRoads() {
        return null;
    }
}
