package org.lumenk.romeonavigation.objects.waypoints;

public abstract class LatticeWaypoint<IdType> extends Waypoint<IdType>{
    public LatticeWaypoint(IdType id) {
        super(id);
    }

    /**
     * 다른 객체와 이웃한지 비교합니다. '이웃하였다'의 기준을 직접 정의하십시오
     * @param other 비교할 대상입니다.
     * @return 이웃하였으면 true, 그렇지 아니하면 false를 반환합니다
     */
    public abstract boolean isNeighborhood(LatticeWaypoint<IdType> other);
    public abstract boolean equals(LatticeWaypoint<IdType> other);
}
