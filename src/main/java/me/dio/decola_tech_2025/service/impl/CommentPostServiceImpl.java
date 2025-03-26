package me.dio.decola_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.domain.model.Comment;
import me.dio.decola_tech_2025.domain.model.User;
import me.dio.decola_tech_2025.domain.repository.CommentRepository;
import me.dio.decola_tech_2025.domain.repository.PostRepository;
import me.dio.decola_tech_2025.domain.repository.UserRepository;
import me.dio.decola_tech_2025.dto.comment.CommentCreateDto;
import me.dio.decola_tech_2025.dto.comment.CommentDto;
import me.dio.decola_tech_2025.service.CommentPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentPostServiceImpl implements CommentPostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public CommentDto create(CommentCreateDto commentDto) {
        var postFound = this.postRepository.findById(commentDto.getPostId()).orElseThrow(NoSuchElementException::new);
        var userFound = userRepository.findById(commentDto.getUserId()).orElseThrow(NoSuchElementException::new);
        Comment comment = new Comment();
        comment.setPost(postFound);
        comment.setUser(userFound);
        comment.setContent(commentDto.getContent());
        return this.modelMapper.map(this.commentRepository.save(comment), CommentDto.class);
    }

    @Override
    @Transactional
    public void delete(Long userId, Long postId, Long commentId) {
        var postFound = this.postRepository.findById(postId).orElseThrow(NoSuchElementException::new);
        var userFound = userRepository.findById(commentId).orElseThrow(NoSuchElementException::new);

        var comment = this.commentRepository.findByUserAndPostAndId(userFound, postFound, commentId)
                .orElseThrow(NoSuchElementException::new);

        this.commentRepository.delete(comment);
    }
}
