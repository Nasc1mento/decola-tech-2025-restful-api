package me.dio.decola_tech_2025.service;


import me.dio.decola_tech_2025.dto.like.LikePostRequestDto;
import me.dio.decola_tech_2025.dto.like.LikeDto;

public interface LikePostService {

    LikeDto like(LikePostRequestDto like);
    void unlike(Long userId, Long postId);
}
