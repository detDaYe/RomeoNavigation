package org.lumenk.romeonavigation.objects.roads;

import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;

public class DistanceRoad<WaypointIdType, RoadIdType> extends Road<OnRoadWaypoint<WaypointIdType, RoadIdType>, WaypointIdType, RoadIdType>{
    private Double distance;
    public DistanceRoad(OnRoadWaypoint<WaypointIdType, RoadIdType> from, OnRoadWaypoint<WaypointIdType, RoadIdType> to, RoadIdType id) {
        super(from, to, id);
        distance = null;
    }

    public DistanceRoad(OnRoadWaypoint<WaypointIdType, RoadIdType> from, OnRoadWaypoint<WaypointIdType, RoadIdType> to, RoadIdType id, @Nullable Double distance) {
        super(from, to, id);
        this.distance = distance;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(@Nullable Double distance) {
        this.distance = distance;
    }
}
