package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface RoadMapData<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> extends WaypointMapData<WaypointIdType, WaypointType> {
    RoadType searchRoad(RoadIdType id, WaypointIdType from, WaypointIdType to);
}
