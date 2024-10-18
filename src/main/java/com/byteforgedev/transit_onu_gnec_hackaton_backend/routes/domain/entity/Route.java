package com.byteforgedev.transit_onu_gnec_hackaton_backend.routes.domain.entity;

import java.math.BigDecimal;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a name for the stop")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @NotBlank(message = "Please add a location for the stop")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String location;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be equal or greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price cannot have more than 10 integer digits and 2 decimal places")
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Embedded
    private Audit audit = new Audit();
}
