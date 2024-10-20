package com.byteforgedev.transit_onu_gnec_hackaton_backend.buses.domain.entity;


import com.byteforgedev.transit_onu_gnec_hackaton_backend.companies.domain.entity.Company;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.routes.domain.entity.Route;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a plate for the bus")
    @Size( max = 50, message = "The bus plate must have a maximum 50 characters")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String plate;

    @NotNull(message = "You need to put the capacity of the bus")
    @DecimalMin(value = "0.0", inclusive = false, message = "The capacity must be greater than 0")
    @Column(name = "capacity")
    private Integer capacity;

    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "route_id", insertable = false, updatable = false)
    private Route route;

}
