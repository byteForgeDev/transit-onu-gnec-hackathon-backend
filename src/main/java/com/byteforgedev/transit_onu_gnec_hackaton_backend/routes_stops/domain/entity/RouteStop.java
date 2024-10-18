package com.byteforgedev.transit_onu_gnec_hackaton_backend.routes_stops.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.routes.domain.entity.Route;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity.Stop;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "routes_stops")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RouteStop {
    @EmbeddedId
    private RouteStopPK id;

    @NotNull(message = "You need to put the position of the stop in the route")
    @DecimalMin(value = "0.0", inclusive = false, message = "The position of the stop must be greater than 0")
    @Column(name = "stop_order")
    private Integer stopOrder;

    @ManyToOne
    @JoinColumn(name = "stop_id", insertable = false, updatable = false)
    private Stop stop;

    @ManyToOne
    @JoinColumn(name = "route_id", insertable = false, updatable = false)
    private Route route;

    @Embedded
    private Audit audit = new Audit();
}
