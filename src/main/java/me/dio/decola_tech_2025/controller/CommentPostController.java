package me.dio.decola_tech_2025.controller;

import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.dto.comment.CommentCreateDto;
import me.dio.decola_tech_2025.dto.comment.CommentDto;
import me.dio.decola_tech_2025.service.CommentPostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/posts/comments")
@RequiredArgsConstructor
public class CommentPostController {

    private final CommentPostService commentPostService;

    @PostMapping
    public ResponseEntity<CommentDto> create(@RequestBody CommentCreateDto commentDto) {
        var commentCreated = this.commentPostService.create(commentDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(commentCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(commentCreated);
    }
}
