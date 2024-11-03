package com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.infrastructure.controllers;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity.Stop;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.services.StopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stops")
public class StopController {

    @Autowired
    private StopService stopService;

    @GetMapping
    public ResponseEntity<List<Stop>> listAllStops(){
        List<Stop> stops = stopService.getAllStops();
        return new ResponseEntity<>(stops, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Stop> saveStop(@Valid @RequestBody Stop stop){
        Stop newStop = stopService.saveStop(stop);
        return new ResponseEntity<>(newStop, HttpStatus.CREATED);
    }
}
