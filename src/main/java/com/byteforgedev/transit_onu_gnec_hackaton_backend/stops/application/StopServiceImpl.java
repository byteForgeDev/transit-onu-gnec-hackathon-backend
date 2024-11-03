package com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.application;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity.Stop;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.services.StopService;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.infrastructure.repositories.StopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StopServiceImpl implements StopService {

    @Autowired
    private StopRepository stopRepository;

    @Override
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    @Override
    public Stop saveStop(Stop stop) {
        return stopRepository.save(stop);
    }
}
