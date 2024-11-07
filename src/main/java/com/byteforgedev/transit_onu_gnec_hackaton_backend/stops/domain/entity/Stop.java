package com.byteforgedev.transit_onu_gnec_hackaton_backend.stops.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "stops")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a name for the stop")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @NotNull(message = "Please add the latitude of the stop")
    @Column(columnDefinition = "NUMERIC(9,6)", nullable = false)
    private Double latitude;

    @NotNull(message = "Please add the longitude of the stop")
    @Column(columnDefinition = "NUMERIC(9,6)", nullable = false)
    private Double longitude;

    @NotBlank(message = "Please add a description for the stop")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Embedded
    private Audit audit = new Audit();

}
