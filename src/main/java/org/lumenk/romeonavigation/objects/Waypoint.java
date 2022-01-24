package org.lumenk.romeonavigation.objects;

import org.jetbrains.annotations.Nullable;

public abstract class Waypoint<ID> {
    protected final ID id;

    protected Waypoint(ID id) {
        this.id = id;
    }

}
