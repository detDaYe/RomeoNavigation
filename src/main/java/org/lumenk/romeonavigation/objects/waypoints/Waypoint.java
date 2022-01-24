package org.lumenk.romeonavigation.objects.waypoints;

public class Waypoint<Id>{

    private final Id id;
    public Waypoint(Id id) {
        this.id = id;
    }

    public Id getId() {
        return id;
    }
}
