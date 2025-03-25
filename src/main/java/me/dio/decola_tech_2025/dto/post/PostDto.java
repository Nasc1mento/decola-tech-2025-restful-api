package me.dio.decola_tech_2025.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.decola_tech_2025.dto.comment.CommentDto;
import me.dio.decola_tech_2025.dto.like.LikeDto;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private List<CommentDto> comments;
    private List<LikeDto> likes;
}
