package org.lumenk.romeonavigation.objects.mapdata;

import org.lumenk.romeonavigation.objects.roads.DistanceRoad;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface DistanceRoadMapData<WaypointIdType, RoadIdType, RoadType extends DistanceRoad<WaypointIdType, RoadIdType>> extends RoadMapData<WaypointIdType, OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType, RoadType>{
}
