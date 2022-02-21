package org.lumenk.romeonavigation.objects.mapdata;

import org.jetbrains.annotations.Nullable;
import org.lumenk.romeonavigation.objects.waypoints.BoundedTenLatticeWaypoint;

import java.util.ArrayList;
import java.util.List;

public class XYPlaneInMemoryLatticeMapData implements LatticeMapData<Integer, BoundedTenLatticeWaypoint>{

    private final BoundedTenLatticeWaypoint[]  waypoints;


    public XYPlaneInMemoryLatticeMapData(){
        waypoints  = new BoundedTenLatticeWaypoint[100];
        for(int i = 0; i < 10; i++)
            for(int j = 0; j < 10; j++){
                final int id = 10 * i + j;
                BoundedTenLatticeWaypoint temp = new BoundedTenLatticeWaypoint(id);
                waypoints[id] = temp;
            }
    }
    @Override
    public BoundedTenLatticeWaypoint searchById(Integer id) {
        final int x = id / 10;
        return x > 10 || x < 0 ? null : waypoints[id];
    }

    @Override
    public @Nullable List<BoundedTenLatticeWaypoint> getNeighborhoods(Integer id) {
        if(searchById(id) == null) return null;
        ArrayList<BoundedTenLatticeWaypoint> result = new ArrayList<>();
        final int x = id / 10;
        final int y = id % 10;

        if(x > 0){
            result.add(waypoints[toId(x - 1, y)]);
        }

        if(x < 9)
            result.add(waypoints[toId(x + 1, y)]);

        if(y > 0)
            result.add(waypoints[toId(x, y - 1)]);
        if(y < 9)
            result.add(waypoints[toId(x, y + 1)]);
        return result;
    }

    private static int toId(int x, int y){
        return 10 * x + y;
    }


}
