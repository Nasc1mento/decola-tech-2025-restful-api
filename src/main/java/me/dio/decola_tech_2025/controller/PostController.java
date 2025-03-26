package me.dio.decola_tech_2025.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.dto.post.PostCreateDto;
import me.dio.decola_tech_2025.dto.post.PostDto;
import me.dio.decola_tech_2025.dto.post.PostUpdateDto;
import me.dio.decola_tech_2025.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;


    @PostMapping
    public ResponseEntity<PostDto> create(@Valid @RequestBody PostCreateDto post) {
        var postCreated = postService.create(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(postCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(postCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update(@PathVariable Long id, @Valid @RequestBody PostUpdateDto postUpdateDto) {
        var postUpdated = this.postService.update(id, postUpdateDto);
        return ResponseEntity.ok(postUpdated);
    }

}
