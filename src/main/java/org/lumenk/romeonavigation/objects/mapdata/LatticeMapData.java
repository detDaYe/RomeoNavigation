package org.lumenk.romeonavigation.objects.mapdata;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.waypoints.LatticeWaypoint;

import java.util.List;

public interface LatticeMapData<WaypointIdType, WaypointType extends LatticeWaypoint<WaypointIdType>> {
    WaypointType searchById(WaypointIdType id);

    /**
     * 제시된 지점과 이웃한 모든 지점을 가져옵니다. 이웃의 기준은 LatticeWaypoint에서 정의하지만 그것을 효율적으로 불러오는 부분은 직접 구현하십시오
     * @param id 제시할 지점
     * @return 잘못된 id가 주어졌다면 null을 반한하되, 고립된 지점이면 빈 리스트를 반환하십시오
     */
    @Nullable
    List<WaypointType> getNeighborhoods(WaypointIdType id);
}
