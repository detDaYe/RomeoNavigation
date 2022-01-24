package org.lumenk.romeonavigation.objects.maps;

import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface RoadMap<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> extends WaypointMap<WaypointIdType, WaypointType>{
    RoadType searchRoadById(RoadIdType id);
}
