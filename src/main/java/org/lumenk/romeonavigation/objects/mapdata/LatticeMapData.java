package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.waypoints.LatticeWaypoint;

import java.util.List;

public interface LatticeMapData<WaypointIdType, WaypointType extends LatticeWaypoint<WaypointIdType>> {
    WaypointType searchById(WaypointIdType id);
    List<WaypointType> getNeighborhoods(WaypointIdType id);
}
