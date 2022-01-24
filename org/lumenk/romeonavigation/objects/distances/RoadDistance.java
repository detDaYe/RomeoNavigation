package org.lumenk.romeonavigation.objects.distances;

import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public class RoadDistance<ROAD_ID, WAYPOINT_ID> extends Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID> implements Distance<WAYPOINT_ID, WAYPOINT_ID> {

    private Double segmentLength;

    public RoadDistance(Waypoint<WAYPOINT_ID> from, Waypoint<WAYPOINT_ID> to, ROAD_ID road_id, Double segmentLength) {
        super(from, to, road_id);
        this.segmentLength = segmentLength;
    }


    @Override
    public @Nullable Double distanceBetween(Waypoint<WAYPOINT_ID> w1, Waypoint<WAYPOINT_ID> w2) {
        return null;
    }

    public Double getSegmentLength() {
        return segmentLength;
    }

    public void setSegmentLength(Double segmentLength) {
        this.segmentLength = segmentLength;
    }
}
