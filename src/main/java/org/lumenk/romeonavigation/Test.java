package org.lumenk.romeonavigation;

import org.lumenk.romeonavigation.finder.RomeoDijkstraRouteFinder;
import org.lumenk.romeonavigation.routeinfo.RomeoRouteInformation;
import org.lumenk.romeonavigation.objects.mapdata.InMemoryRoadMapData;
import org.lumenk.romeonavigation.objects.roads.FixedDistanceRoad;
import org.lumenk.romeonavigation.objects.waypoints.OnRoadWaypointInMemoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        System.out.println("hi");

        InMemoryRoadMapData<Integer, Integer, FixedDistanceRoad<Integer, Integer>> mapData = new InMemoryRoadMapData<>();

        OnRoadWaypointInMemoryImpl<Integer, Integer> w0 = new OnRoadWaypointInMemoryImpl<>(0);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w1 = new OnRoadWaypointInMemoryImpl<>(1);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w2 = new OnRoadWaypointInMemoryImpl<>(2);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w3 = new OnRoadWaypointInMemoryImpl<>(3);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w4 = new OnRoadWaypointInMemoryImpl<>(4);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w5 = new OnRoadWaypointInMemoryImpl<>(5);
        OnRoadWaypointInMemoryImpl<Integer, Integer> w6 = new OnRoadWaypointInMemoryImpl<>(6);

        FixedDistanceRoad<Integer, Integer> r01 = new FixedDistanceRoad<>(w0, w1, 0, 7.0);
        FixedDistanceRoad<Integer, Integer> r04 = new FixedDistanceRoad<>(w0, w4, 0, 3.0);
        FixedDistanceRoad<Integer, Integer> r05 = new FixedDistanceRoad<>(w0, w5, 0, 10.0);

        FixedDistanceRoad<Integer, Integer> r10 = new FixedDistanceRoad<>(w1, w0, 1, 7.0);
        FixedDistanceRoad<Integer, Integer> r12 = new FixedDistanceRoad<>(w1, w2, 1, 2.0);
        FixedDistanceRoad<Integer, Integer> r13 = new FixedDistanceRoad<>(w1, w3, 1, 10.0);
        FixedDistanceRoad<Integer, Integer> r14 = new FixedDistanceRoad<>(w1, w4, 1, 2.0);
        FixedDistanceRoad<Integer, Integer> r15 = new FixedDistanceRoad<>(w1, w5, 1, 6.0);

        FixedDistanceRoad<Integer, Integer> r21 = new FixedDistanceRoad<>(w2, w1, 2, 4.0);
        FixedDistanceRoad<Integer, Integer> r23 = new FixedDistanceRoad<>(w2, w3, 2, 2.0);

        FixedDistanceRoad<Integer, Integer> r31 = new FixedDistanceRoad<>(w3, w1, 3, 10.0);
        FixedDistanceRoad<Integer, Integer> r32 = new FixedDistanceRoad<>(w3, w2, 3, 2.0);
        FixedDistanceRoad<Integer, Integer> r35 = new FixedDistanceRoad<>(w3, w5, 3, 9.0);
        FixedDistanceRoad<Integer, Integer> r36 = new FixedDistanceRoad<>(w3, w6, 3, 4.0);

        FixedDistanceRoad<Integer, Integer> r40 = new FixedDistanceRoad<>(w4, w0, 4, 3.0);
        FixedDistanceRoad<Integer, Integer> r41 = new FixedDistanceRoad<>(w4, w1, 4, 2.0);
        FixedDistanceRoad<Integer, Integer> r46 = new FixedDistanceRoad<>(w4, w6, 4, 5.0);

        FixedDistanceRoad<Integer, Integer> r50 = new FixedDistanceRoad<>(w5, w0, 5, 10.0);
        FixedDistanceRoad<Integer, Integer> r51 = new FixedDistanceRoad<>(w5, w1, 5, 6.0);
        FixedDistanceRoad<Integer, Integer> r53 = new FixedDistanceRoad<>(w5, w3, 5, 9.0);

        FixedDistanceRoad<Integer, Integer> r64 = new FixedDistanceRoad<>(w6, w4, 6, 5.0);
        FixedDistanceRoad<Integer, Integer> r63 = new FixedDistanceRoad<>(w6, w3, 6, 4.0);

        List.of(r01, r04, r05).forEach(r -> w0.getConnectedRoads().add(r));
        List.of(r10, r12, r13, r14, r15).forEach(r -> w1.getConnectedRoads().add(r));
        List.of(r21, r23).forEach((r -> w2.getConnectedRoads().add(r)));
        List.of(r31, r32, r36, r35).forEach(r -> w3.getConnectedRoads().add(r));
        List.of(r40, r41, r46).forEach(r -> w4.getConnectedRoads().add(r));
        List.of(r50, r51, r53).forEach(r -> w5.getConnectedRoads().add(r));

        List.of(r63, r64).forEach(r -> w6.getConnectedRoads().add(r));

        List.of(w0, w1, w2, w3, w4, w5, w6).forEach(mapData::addWaypoint);
        List.of(
                r01, r04, r05,
                r10, r12, r13, r14, r15,
                r21, r23,
                r31, r32, r35, r36,
                r40, r41, r46,
                r50, r51, r53,
                r63, r64
        ).forEach(mapData::addRoad);

        RomeoRouteInformation<Integer, Integer> info = RomeoDijkstraRouteFinder.find(
                0, 3, mapData
        );

        ArrayList<RomeoRouteInformation<Integer, Integer>.RouteSegment> result = Objects.requireNonNull(info).getSegments();
        result.forEach(s -> System.out.printf(
                "from %d to %d via %d sums : %f%n",
                s.getFrom(), s.getTo(), s.getVia(), s.getSums()
        ));






    }
}
