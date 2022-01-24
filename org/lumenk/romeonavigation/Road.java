package org.lumenk.romeonavigation;

public class Road<ID, WAYPOINT_1_ID, WAYPOINT_2_ID> {
    private Waypoint<WAYPOINT_1_ID> from;
    private Waypoint<WAYPOINT_2_ID> to;
    private ID id;

    public Road(Waypoint<WAYPOINT_1_ID> from, Waypoint<WAYPOINT_2_ID> to, ID id) {
        this.from = from;
        this.to = to;
        this.id = id;
    }

    public Waypoint<WAYPOINT_1_ID> getFrom() {
        return from;
    }

    public void setFrom(Waypoint<WAYPOINT_1_ID> from) {
        this.from = from;
    }

    public Waypoint<WAYPOINT_2_ID> getTo() {
        return to;
    }

    public void setTo(Waypoint<WAYPOINT_2_ID> to) {
        this.to = to;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
