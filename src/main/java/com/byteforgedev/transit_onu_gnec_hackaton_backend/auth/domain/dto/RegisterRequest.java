package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "The username can't be empty")
    @Size(min = 4, max = 20, message = "The username must have minimum 4 and maximum 20 characters")
    private String username;

    @NotBlank(message = "You need a password")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    private String password;

    @NotBlank(message = "Please add a email")
    @Size(min = 4, max = 255, message = "The username must have minimum 4 and maximum 255 characters")
    @Email(message = "The email must be in this format: johndoe@gmail.com")
    private String email;

    @Column(name= "photo_profile_url" ,columnDefinition = "TEXT", nullable = false)
    private String photoProfileUrl;

    @NotBlank(message = "Please add a name for the city")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String cityName;

    @NotBlank(message = "Please add a name for the country")
    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    private String countryName;

    // @NotBlank(message = "Por favor, añade un rol")
    private List<String> roles;
}
