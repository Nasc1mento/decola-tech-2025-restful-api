package me.dio.decola_tech_2025.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.decola_tech_2025.domain.model.Comment;
import me.dio.decola_tech_2025.domain.model.Like;
import me.dio.decola_tech_2025.dto.comment.CommentDto;
import me.dio.decola_tech_2025.dto.user.UserDto;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private UserDto user;
    private Set<CommentDto> comments;
    private Set<Like> likes;
}
