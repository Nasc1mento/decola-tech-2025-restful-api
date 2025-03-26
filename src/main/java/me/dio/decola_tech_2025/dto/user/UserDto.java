package me.dio.decola_tech_2025.dto.user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
}
