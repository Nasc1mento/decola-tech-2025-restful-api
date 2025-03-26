package me.dio.decola_tech_2025.controller;

import jakarta.validation.Valid;
import me.dio.decola_tech_2025.dto.like.LikePostRequestDto;
import me.dio.decola_tech_2025.dto.like.LikeDto;
import me.dio.decola_tech_2025.service.LikePostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like-post")
public class LikePostController {

    private final LikePostService likePostService;

    public LikePostController(LikePostService likePostService) {
        this.likePostService = likePostService;
    }

    @PostMapping
    public ResponseEntity<LikeDto> giveLikeToPost(@Valid @RequestBody LikePostRequestDto likeToPost) {
        var like = this.likePostService.like(likeToPost);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping
    public ResponseEntity<Void> removeLikeFromPost(@Valid @RequestBody LikePostRequestDto likePostDto) {
        this.likePostService.unlike(likePostDto);
        return ResponseEntity.noContent().build();
    }

}
