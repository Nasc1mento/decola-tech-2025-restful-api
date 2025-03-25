package me.dio.decola_tech_2025.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class UserCreateDto {

    @Size(min = 3, max = 15)
    @NotNull(message = "username cannot be null")
    String username;

    @Size(min = 8, max = 30)
    @NotNull(message = "password cannot be null")
    String password;
}
