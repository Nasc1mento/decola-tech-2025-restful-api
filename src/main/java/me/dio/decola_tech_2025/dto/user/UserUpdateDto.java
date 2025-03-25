package me.dio.decola_tech_2025.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdateDto {

    @Size(min = 3, max = 15, message = "username must be between 3 and 15 characters ")
    @NotNull(message = "username cannot be null")
    String username;

    @Size(min = 8, max = 30, message = "password must be between 3 and 15 characters")
    @NotNull(message = "username cannot be null")
    String password;
}

