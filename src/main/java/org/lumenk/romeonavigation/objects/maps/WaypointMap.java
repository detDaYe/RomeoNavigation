package org.lumenk.romeonavigation.objects.maps;

import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface WaypointMap<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>> {

    WaypointType searchWaypointById(WaypointIdType id);

}
