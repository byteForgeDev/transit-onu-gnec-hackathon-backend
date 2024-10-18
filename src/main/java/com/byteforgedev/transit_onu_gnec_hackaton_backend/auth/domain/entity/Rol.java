package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity;

import java.util.List;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"users"})
@ToString(exclude = {"users"})
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The rol can't be empty")
    @Size(min = 4, max = 20, message = "The rol must have minimum 4 and maximum 20 characters")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String rol;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
    @JsonIgnoreProperties({"roles", "handler", "hibernateLazyInitializer"})
    private List<User> users;

    @Embedded
    private Audit audit = new Audit();
}
