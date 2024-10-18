package com.byteforgedev.transit_onu_gnec_hackaton_backend.countries.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a name for the country")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Embedded
    private Audit audit = new Audit();
}
