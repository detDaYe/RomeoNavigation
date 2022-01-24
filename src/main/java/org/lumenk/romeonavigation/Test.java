package org.lumenk.romeonavigation;

import org.lumenk.romeonavigation.datastructures.RomeoStack;
import org.lumenk.romeonavigation.objects.mapdata.InMemoryRoadMapData;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypoint;

public class Test {
    public static void main(String[] args) {
        System.out.println("hi");

        InMemoryRoadMapData<Integer, Integer> mapData = new InMemoryRoadMapData<>();

        OnRoadWaypoint<Integer, Integer> w1, w2, w3;
        FixedDistanceRoad<Integer, Integer> r1, r2, r3, rr1, rr2, rr3;

    }
}
