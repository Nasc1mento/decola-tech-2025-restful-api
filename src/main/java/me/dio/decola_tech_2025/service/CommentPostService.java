package me.dio.decola_tech_2025.service;

import me.dio.decola_tech_2025.dto.comment.CommentCreateDto;
import me.dio.decola_tech_2025.dto.comment.CommentDto;

public interface CommentPostService {

    CommentDto create(CommentCreateDto commentDto);
    void delete(Long userId, Long postId, Long commentId);
}
