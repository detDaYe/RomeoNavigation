package org.lumenk.romeonavigation.finder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.distances.Distance;
import org.lumenk.romeonavigation.objects.mapdata.MapData;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.RoadOnlyWayPoint;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;
import org.lumenk.romeonavigation.utils.RomeoQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class SimpleFinder {


    @Nullable
    public static <WAYPOINT_ID, ROAD_ID> ArrayList<RoadOnlyWayPoint<WAYPOINT_ID, ROAD_ID>> find(@NotNull RoadOnlyWayPoint<WAYPOINT_ID, ROAD_ID> departure,
                                                                                                @NotNull RoadOnlyWayPoint<WAYPOINT_ID, ROAD_ID> arrival,
                                                                                                @NotNull MapData<ROAD_ID, WAYPOINT_ID> map,
                                                                                                @NotNull Distance<WAYPOINT_ID, WAYPOINT_ID> distance){

        HashMap<WAYPOINT_ID,WAYPOINT_ID> prevNode = new HashMap<>();
        HashMap<WAYPOINT_ID, Double> sums = new HashMap<>();
        ArrayList<Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID>> roadTemp;

        RoadOnlyWayPoint<WAYPOINT_ID, ROAD_ID> selected = departure;

        sums.put(departure.getId(), 0.0);
        prevNode.put(departure.getId(), departure.getId());

        Double minValue = null;
        Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID> minRoad = null;

        RomeoQueue<Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID>> queue = new RomeoQueue<>();
        RomeoQueue<Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID>> queueTemp = new RomeoQueue<>();
        while (true){
            roadTemp = selected.getConnectedRoads();
            roadTemp.forEach(r -> {
                if(prevNode.getOrDefault(r.getTo().getId(), null) == null)
                    queue.enqueue(r);

            });

            minValue = Double.MAX_VALUE;
            while(queue.getCount() > 0){
                Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID> current = queue.dequeue();

                Double d = distance.distanceBetween(Objects.requireNonNull(current).getFrom(), current.getTo());
                if(d == null)continue;
                if(d + sums.get(current.getFrom().getId()) < minValue){
                    if(minRoad!=null)
                        queueTemp.enqueue(minRoad);
                    minRoad = current;
                    minValue = d + sums.get(current.getFrom().getId());
                }else
                    queueTemp.enqueue(current);

            }

            while(queueTemp.getCount() > 0)
                queue.enqueue(Objects.requireNonNull(queueTemp.dequeue()));








            if(queue.getCount() == 0)break;

        }
        return null;
    }
}
