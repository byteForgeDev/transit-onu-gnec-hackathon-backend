package com.byteforgedev.transit_onu_gnec_hackaton_backend.routes_stops.domain.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RouteStopPK implements Serializable{
    @Column(name = "route_id")
    private Long route;

    @Column(name = "stop_id")
    private Long stop;
}
