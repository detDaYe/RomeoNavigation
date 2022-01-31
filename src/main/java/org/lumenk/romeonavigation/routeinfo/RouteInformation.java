package org.lumenk.romeonavigation.routeinfo;

import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.ArrayList;

public interface RouteInformation<SegmentInfoType extends SegmentInformation<WaypointIdType, WaypointType, RoadIdType, RoadType>, WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> {
    SegmentInfoType[] toArray();
}
