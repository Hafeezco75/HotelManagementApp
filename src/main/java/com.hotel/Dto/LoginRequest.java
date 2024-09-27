package com.hotel.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Email required")
    private String email;
    @NotBlank(message = "Password required")
    private String password;

}

