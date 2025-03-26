package me.dio.decola_tech_2025.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.dto.like.LikePostRequestDto;
import me.dio.decola_tech_2025.dto.like.LikeDto;
import me.dio.decola_tech_2025.service.LikePostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikePostController {

    private final LikePostService likePostService;

    @PostMapping
    public ResponseEntity<LikeDto> giveLikeToPost(@Valid @RequestBody LikePostRequestDto likeToPost) {
        var like = this.likePostService.like(likeToPost);
        return ResponseEntity.ok(like);
    }

    @DeleteMapping("/{userId}/{postId}")
    public ResponseEntity<Void> removeLikeFromPost(@PathVariable Long userId, @PathVariable Long postId) {
        this.likePostService.unlike(userId, postId);
        return ResponseEntity.noContent().build();
    }

}
