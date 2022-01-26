package org.lumenk.romeonavigation;

import org.lumenk.romeonavigation.datastructures.RomeoStack;
import org.lumenk.romeonavigation.finder.FixedDistanceDijkstra;
import org.lumenk.romeonavigation.objects.RouteInfo;
import org.lumenk.romeonavigation.objects.mapdata.InMemoryRoadMapData;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypointInMemoryImpl;

import java.util.ArrayList;

import static java.awt.SystemColor.info;

public class Test {
    public static void main(String[] args) {
        System.out.println("hi");

        InMemoryRoadMapData<Integer, Integer> mapData = new InMemoryRoadMapData<>();

        OnRoadWaypoint<Integer, Integer> w1, w2, w3;
        FixedDistanceRoad<Integer, Integer> r1, r2, r3, rr1, rr2, rr3;

        //r1 = new FixedDistanceRoad<>(w1, w2, 1, 1.0);
        w1 = new OnRoadWaypointInMemoryImpl<>(1);
        w2 = new OnRoadWaypointInMemoryImpl<>(2);
        w3 = new OnRoadWaypointInMemoryImpl<>(3);

        r1 = new FixedDistanceRoad<>(w1, w2, 12, 1.0); w1.getConnectedRoads().add(r1);
        rr1 = new FixedDistanceRoad<>(w2, w1, 21, 1.0); w2.getConnectedRoads().add(rr1);

        r2 = new FixedDistanceRoad<>(w2, w3, 23, 2.0); w2.getConnectedRoads().add(r2);
        rr2 = new FixedDistanceRoad<>(w3, w2, 32, 2.0); w3.getConnectedRoads().add(rr2);

        r3 = new FixedDistanceRoad<>(w3, w1, 31, 4.0); w3.getConnectedRoads().add(r3);
        rr3 = new FixedDistanceRoad<>(w1, w3, 13, 4.0); w1.getConnectedRoads().add(rr3);






        mapData.addWaypoint(w1);
        mapData.addWaypoint(w2);
        mapData.addWaypoint(w3);

        mapData.addRoad(r1);mapData.addRoad(rr1);
        mapData.addRoad(r2);mapData.addRoad(rr2);
        mapData.addRoad(r3);mapData.addRoad(rr3);

        ArrayList<RouteInfo<Integer, Integer>> result = FixedDistanceDijkstra.find(mapData, 1, 3);
        if(result == null) System.out.println("OMG!!");

        result.forEach(info -> System.out.printf(
                "from %d |to %d |via %d |distance sums : %f%n", info.getFrom(), info.getTo(),info.getVia() ,info.getSumOfWeight()
        ));

    }
}
