package org.lumenk.romeonavigation.objects.distances;

import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public interface Distance<ID1, ID2> {

    /**
     * w1에서 w2로의 거리를 측정합니다. 이 때 w1에서 w2까지에서 필요한 경유지점은 없어야 합니다.
     * @param w1 출발지점
     * @param w2 도착지점
     * @return 거리가 정의되지 않는 경우 null을 반환합니다. 다만 w1과 w2가 직접 연결되지 않았을 때에도 같습니다.
     */
    @Nullable
    Double distanceBetween(Waypoint<ID1> w1, Waypoint<ID2> w2);
}
