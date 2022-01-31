package org.lumenk.romeonavigation.objects;

import org.lumenk.romeonavigation.objects.waypoints.LatticeWaypoint;


public abstract class LatticeDistance<WaypointType extends LatticeWaypoint<WaypointIdType>, WaypointIdType> implements Distance<WaypointType, WaypointIdType>{
    @Override
    public Double between(WaypointType from, WaypointType to) {
        return from.isNeighborhood(to) ? betweenWithConnected(from, to) : null;
    }

    protected abstract double betweenWithConnected(WaypointType from, WaypointType to);
}
