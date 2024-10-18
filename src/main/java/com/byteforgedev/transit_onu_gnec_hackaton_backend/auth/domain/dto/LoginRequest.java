package com.byteforgedev.transit_onu_gnec_hackaton_backend.auth.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "Digita el usuario")
    @Size(min = 4, max = 20, message = "min 4 and max 20 characters")
    String username;

    @NotBlank(message = "Digita la contraseña")
    @Size(min = 4, max = 255, message = "min 4 and max 255 characters")
    String password;
}