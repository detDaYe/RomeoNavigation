package org.lumenk.romeonavigation.routeinfo;

import org.jetbrains.annotations.NotNull;
import org.lumenk.romeonavigation.objects.roads.Road;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

import java.util.ArrayList;

public interface RouteInformation<SegmentInfoType extends SegmentInformation<WaypointIdType, WaypointType, RoadIdType, RoadType>, WaypointIdType, WaypointType extends Waypoint<WaypointIdType>, RoadIdType, RoadType extends Road<WaypointType, WaypointIdType, RoadIdType>> {
    /**
     * 순서에 맞게 반환해야 합니다
     * @return 찾아낸 경로를 차례대로 배열로 잘 만들어서 반환하도록 구현하십시오.
     */
    @NotNull
    SegmentInfoType[] toArray();
}
