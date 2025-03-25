package me.dio.decola_tech_2025.service.impl;

import me.dio.decola_tech_2025.domain.model.Post;
import me.dio.decola_tech_2025.domain.repository.PostRepository;
import me.dio.decola_tech_2025.dto.post.PostCreateDto;
import me.dio.decola_tech_2025.dto.post.PostDto;
import me.dio.decola_tech_2025.dto.post.PostUpdateDto;
import me.dio.decola_tech_2025.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public PostDto create(PostCreateDto postToCreate) {
       var postCreated = this.postRepository.save(this.modelMapper.map(postToCreate, Post.class));
       return this.modelMapper.map(postCreated, PostDto.class);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PostDto update(Long id, PostUpdateDto u) {
        return null;
    }
}
