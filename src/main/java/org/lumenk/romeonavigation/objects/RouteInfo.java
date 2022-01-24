package org.lumenk.romeonavigation.objects;

public class RouteInfo<WaypointIdType, RoadIdType> {
    private final WaypointIdType from;
    private final WaypointIdType to;
    private final RoadIdType via;
    private final double weight;

    public RouteInfo(WaypointIdType from, WaypointIdType to, RoadIdType via, double weight) {
        this.from = from;
        this.to = to;
        this.via = via;
        this.weight = weight;
    }

    public WaypointIdType getFrom() {
        return from;
    }

    public WaypointIdType getTo() {
        return to;
    }

    public RoadIdType getVia() {
        return via;
    }

    public double getWeight() {
        return weight;
    }
}
