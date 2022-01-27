package org.lumenk.romeonavigation.objects;

import java.util.ArrayList;

public class RomeoRouteInformation<WaypointIdType, RoadIdType> {

    private final ArrayList<RouteSegment> segments = new ArrayList<>();

    public void addSegment(WaypointIdType from, WaypointIdType to, RoadIdType via, double sum){
        segments.add(new RouteSegment(from, to, via, sum));
    }

    public ArrayList<RouteSegment> getSegments() {
        return segments;
    }

    private class RouteSegment{
        //


        public RouteSegment(WaypointIdType from, WaypointIdType to, RoadIdType via, double sums) {
            this.from = from;
            this.to = to;
            this.via = via;
            this.sums = sums;
        }

        WaypointIdType from;
        WaypointIdType to;
        RoadIdType via;
        double sums;
    }
}
