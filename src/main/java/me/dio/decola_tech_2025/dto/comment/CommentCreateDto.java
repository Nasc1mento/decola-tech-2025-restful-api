package me.dio.decola_tech_2025.dto.comment;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDto {
    private Long userId;
    private Long postId;
    private String content;
}
