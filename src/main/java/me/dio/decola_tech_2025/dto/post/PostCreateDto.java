package me.dio.decola_tech_2025.dto.post;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDto {

    @NotNull(message = "title cannot be null")
    @Size(min = 1, max = 50)
    private String title;

    @NotNull(message = "title cannot be null")
    @Size(min = 1, max = 3600)
    private String content;

}
