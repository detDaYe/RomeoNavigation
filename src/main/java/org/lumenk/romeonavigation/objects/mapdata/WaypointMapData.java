package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface WaypointMapData<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>> {

    WaypointType searchWaypointById(WaypointIdType id);

}
