package com.byteforgedev.transit_onu_gnec_hackaton_backend.companies.domain.entity;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity.User;
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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please add a name for the company")
    @Size( max = 50, message = "The company name must have a maximum 50 characters")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String name;

    @Embedded
    private Audit audit = new Audit();

    @ManyToOne
    @JoinColumn(name = "manager_user_id", insertable = false, updatable = false)
    private User user;
}
