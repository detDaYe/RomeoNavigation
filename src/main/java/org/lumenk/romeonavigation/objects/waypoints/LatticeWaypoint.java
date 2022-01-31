package org.lumenk.romeonavigation.objects.waypoints;

public abstract class LatticeWaypoint<IdType> extends Waypoint<IdType>{
    public LatticeWaypoint(IdType id) {
        super(id);
    }

    public abstract boolean isNeighborhood(LatticeWaypoint<IdType> other);
    public abstract boolean equals(LatticeWaypoint<IdType> other);
}
