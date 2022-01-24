package org.lumenk.romeonavigation.objects.waypoints;

public abstract class RomeoWaypoint<Id>{

    private final Id id;
    public RomeoWaypoint(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }
}
