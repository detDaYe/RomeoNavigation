package org.lumenk.romeonavigation.objects.waypoints;

public class BoundedTenLatticeWaypoint extends LatticeWaypoint<Integer>{
    public BoundedTenLatticeWaypoint(Integer id) {
        super(id);
    }

    @Override
    public boolean isNeighborhood(LatticeWaypoint<Integer> other) {
        final int ox = other.getId() / 10;
        final int oy = other.getId() % 10;

        return Math.abs(ox - getId() / 10) == 1 && Math.abs(oy - getId() % 10) == 1;
    }

    @Override
    public boolean equals(LatticeWaypoint<Integer> other) {
        return other.getId().equals(getId());
    }
}
