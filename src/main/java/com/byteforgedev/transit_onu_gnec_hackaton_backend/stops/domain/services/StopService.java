package com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.services;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity.Stop;

import java.util.List;

public interface StopService {

    List<Stop> getAllStops();

    Stop saveStop(Stop stop);
}
