package org.lumenk.romeonavigation.objects.mapdata;

import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.ArrayList;

public interface MapData<ROAD_ID, WAYPOINT_ID> {

    /**
     * 길의 목록을 조회합니다
     * @param id 길의 id입니다
     * @return 주어진 id를 가진 모든 길을 찾습니다
     */
    @Nullable
    ArrayList<Road<ROAD_ID, WAYPOINT_ID, WAYPOINT_ID>> searchRoadById(ROAD_ID id);

    @Nullable
    Waypoint<WAYPOINT_ID> searchWaypointById(WAYPOINT_ID id);
}
