package com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.infrastructure.repositories;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop, Long> {
}
