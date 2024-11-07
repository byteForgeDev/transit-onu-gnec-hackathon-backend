package com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity.Country;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a name for the city")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Embedded
    @Builder.Default
    private Audit audit = new Audit();

    @NotNull(message = "Please select a country")
    @ManyToOne
    @JoinColumn(name = "country_id", insertable = true, updatable = true)
    private Country country;
}
