package org.lumenk.romeonavigation.objects;

import java.util.ArrayList;

public class RoadOnlyWayPoint<ID, ROAD_ID> extends Waypoint<ID>{
    
    private final ArrayList<Road<ROAD_ID, ID, ID>> connectedRoads = new ArrayList<>();
    
    protected RoadOnlyWayPoint(ID id) {
        super(id);
    }

    public ArrayList<Road<ROAD_ID, ID, ID>> getConnectedRoads() {
        return connectedRoads;
    }
}
