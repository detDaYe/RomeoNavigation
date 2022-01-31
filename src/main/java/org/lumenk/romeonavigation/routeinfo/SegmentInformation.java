package org.lumenk.romeonavigation.routeinfo;

import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface SegmentInformation<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> {

}
