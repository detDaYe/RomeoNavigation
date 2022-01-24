package org.lumenk.romeonavigation.objects;

import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface Distance<WaypointType extends Waypoint<WayPointIdType>, WayPointIdType> {
    /**
     * 두 Waypoint 사이의 거리를 측정합니다. 시간, 비용 혹은 그 외의 가치 등 입맞에 따라 구현하십시오.
     * 다만, 거리인만큼 0 이상의 값을 두도록 구현할 것을 권장합니다.
     * 시작지점과 도착지점을 따로 둔 이유는, 일방통행로 등을 고려한 것입니다.
     * 연결된 두 지점이 아닌 경우 올바르지 못한 측정으로 간주하여야 합니다.
     * @param from 시점입니다.
     * @param to 종점입니다.
     * @return 측정한 거리를 반환합니다. 올바르지 못한 측정을 요구한 경우 Null을 반환하십시오
     */
    Double between(WaypointType from, WaypointType to);
}
