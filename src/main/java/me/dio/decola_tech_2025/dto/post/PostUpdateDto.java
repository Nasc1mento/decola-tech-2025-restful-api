package me.dio.decola_tech_2025.dto.post;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.decola_tech_2025.domain.model.Comment;
import me.dio.decola_tech_2025.domain.model.Like;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostUpdateDto {

    @NotNull(message = "title cannot be null")
    @Size(min = 1, max = 50)
    private String title;

    @NotNull(message = "title cannot be null")
    @Size(min = 1, max = 3600)
    private String content;

    private Set<Comment> comments;

    private Set<Like> likes;
}
