package org.lumenk.romeonavigation.finder;

import org.jetbrains.annotations.NotNull;
import org.lumenk.romeonavigation.objects.maps.RoadMap;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.HashMap;
import java.util.Objects;

public class FixedDistanceDijkstra {
    public static <WaypointIdType,
            RoadIdType> void find(RoadMap<WaypointIdType,
            OnRoadWaypoint<WaypointIdType, RoadIdType>, RoadIdType, FixedDistanceRoad<WaypointIdType, RoadIdType>> map, WaypointIdType departureId, WaypointIdType arrivalId){

        HashMap<WaypointIdType, WaypointIdType> visitBefore = new HashMap<>();
        HashMap<WaypointIdType, Double> distanceSum = new HashMap<>();

        visitBefore.put(departureId, departureId);
        distanceSum.put(departureId, 0.0);

        OnRoadWaypoint<WaypointIdType, RoadIdType> added = Objects.requireNonNull(map.searchWaypointById(departureId));

        while(true){

        }


    }
}
