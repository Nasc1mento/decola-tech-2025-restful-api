package me.dio.decola_tech_2025.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.decola_tech_2025.domain.model.Comment;
import me.dio.decola_tech_2025.domain.model.Like;
import me.dio.decola_tech_2025.domain.model.Post;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private Set<Post> articles;
    private Set<Comment> comments;
    private Set<Like> likes;
}
