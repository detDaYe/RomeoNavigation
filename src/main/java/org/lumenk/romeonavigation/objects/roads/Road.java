package org.lumenk.romeonavigation.objects.roads;

import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

/**
 *
 * @param <WaypointType> Waypoint 객체타입입니다.
 * @param <WaypointIdType> Waypoint 객체의 id타입입니다.
 * @param <RoadIdType> Road 객체의 id타입입니다.
 */
public class Road<WaypointType extends Waypoint<WaypointIdType>, WaypointIdType, RoadIdType> {
    protected final WaypointType from;
    protected final WaypointType to;
    protected final RoadIdType id;

    public Road(WaypointType from, WaypointType to, RoadIdType id) {
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public WaypointType getFrom() {
        return from;
    }

    public WaypointType getTo() {
        return to;
    }

    public RoadIdType getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Road<?, ?, ?> road = (Road<?, ?, ?>) o;

        if (!from.equals(road.from)) return false;
        if (!to.equals(road.to)) return false;
        return id.equals(road.id);
    }

    @Override
    public int hashCode() {
        int result = from.hashCode();
        result = 31 * result + to.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}