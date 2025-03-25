package me.dio.decola_tech_2025.service;


import me.dio.decola_tech_2025.dto.post.PostCreateDto;
import me.dio.decola_tech_2025.dto.post.PostDto;
import me.dio.decola_tech_2025.dto.post.PostUpdateDto;

public interface PostService {
    PostDto create(PostCreateDto u);

    void delete(Long id);

    PostDto update(Long id, PostUpdateDto u);
}
