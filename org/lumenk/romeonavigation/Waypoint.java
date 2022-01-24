package org.lumenk.romeonavigation;

import org.jetbrains.annotations.Nullable;

public abstract class Waypoint<ID> {
    protected final ID id;

    protected Waypoint(ID id) {
        this.id = id;
    }

    /**
     * 다른 Waypoint와의 거리를 측정합니다.
     * @param other 측정의 대상이 되는 Waypoint객체입니다.
     * @return 정의될 수 없는 Waypoint을 입력받았을 경우 null을 반환하십시오
     */
    @Nullable
    public abstract <OtherId> Double distance(Waypoint<OtherId> other);

}
