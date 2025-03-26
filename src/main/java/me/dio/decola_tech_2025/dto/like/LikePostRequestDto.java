package me.dio.decola_tech_2025.dto.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikePostRequestDto {
    private Long userId;
    private Long postId;
}
