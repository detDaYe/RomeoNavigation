package org.lumenk.romeonavigation.objects.waypoints;

import org.jetbrains.annotations.Nullable;

public abstract class Waypoint<ID> {
    protected final ID id;

    protected Waypoint(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }
}
