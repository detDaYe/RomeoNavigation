package org.lumenk.romeonavigation.routeinfo;

import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public abstract class SegmentInformation<WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> {
    protected final WaypointType from;
    protected final WaypointType to;
    protected final RoadType via;
    protected final double length;

    protected SegmentInformation(WaypointType from, WaypointType to, RoadType via, double length) {
        this.from = from;
        this.to = to;
        this.via = via;
        this.length = length;
    }

    public WaypointType getFrom() {
        return from;
    }

    public WaypointType getTo() {
        return to;
    }

    public RoadType getVia() {
        return via;
    }

    public double getLength() {
        return length;
    }
}
