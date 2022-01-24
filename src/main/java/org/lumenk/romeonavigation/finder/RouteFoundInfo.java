package org.lumenk.romeonavigation.finder;

import org.lumenk.romeonavigation.objects.waypoints.Waypoint;

public class RouteFoundInfo<ID_1, ID_2> {
    Waypoint<ID_1> departure;
    Waypoint<ID_2> arrival;
}
