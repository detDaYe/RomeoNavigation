package org.lumenk.romeonavigation.objects.roads;

import org.lumenk.romeonavigation.objects.waypoints.LatticeWaypoint;

public class LatticeEdgeRoad<WaypointIdType, WaypointType extends LatticeWaypoint<WaypointIdType>, RoadIdType> extends Road<WaypointType, WaypointIdType, RoadIdType>{
    public LatticeEdgeRoad(WaypointType from, WaypointType to, RoadIdType id) {
        super(from, to, id);
    }
}
