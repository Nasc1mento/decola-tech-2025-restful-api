package me.dio.decola_tech_2025.controller;

import jakarta.validation.Valid;
import me.dio.decola_tech_2025.dto.post.PostCreateDto;
import me.dio.decola_tech_2025.dto.post.PostDto;
import me.dio.decola_tech_2025.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostCreateDto post) {
        var postCreated = postService.create(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(postCreated);
    }

}
