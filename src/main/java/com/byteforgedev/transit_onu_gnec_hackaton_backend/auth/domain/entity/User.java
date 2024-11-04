package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.byteforgedev.transit_onu_gnec_hackaton_backend.cities.domain.entity.City;
import com.byteforgedev.transit_onu_gnec_hackaton_backend.utils.Audit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users",  uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "BOOL", nullable = false)
    private boolean enabled;

    @NotBlank(message = "The username can't be empty")
    @Size(min = 4, max = 20, message = "The username must have minimum 4 and maximum 20 characters")
    @Column(columnDefinition = "VARCHAR(20)", nullable = false, unique = true)
    private String username;

    @NotBlank(message = "You need a password")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String password;

    @NotBlank(message = "Please add a email")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    @Column(columnDefinition = "VARCHAR(255)", nullable = false, unique = true) 
    @Email(message = "The email must be in this format: johndoe@gmail.com")
    private String email;

    
    @Column(name= "photo_profile_url" ,columnDefinition = "TEXT", nullable = false)
    private String photoProfileUrl;

    @Embedded
    @Builder.Default
    private Audit audit = new Audit();

    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;

    @PrePersist
    public void prePersist() {
        enabled = true;
    }

    @JsonIgnoreProperties({"users", "handler", "hibernateLazyInitializer"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "usuarios_roles", 
        joinColumns = @JoinColumn(name = "usuario_id"), 
        inverseJoinColumns = @JoinColumn(name = "rol_id"),
        uniqueConstraints = { @UniqueConstraint(columnNames = {"usuario_id", "rol_id"})}
    )
    private List<Rol> roles;


    @ManyToOne
    @JoinColumn(name = "city_id", insertable = true, updatable = true)
    private City city;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRol())) 
                    .toList(); 
    }
}
