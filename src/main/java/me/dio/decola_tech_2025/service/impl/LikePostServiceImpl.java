package me.dio.decola_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.domain.model.Like;
import me.dio.decola_tech_2025.domain.repository.LikeRepository;
import me.dio.decola_tech_2025.domain.repository.PostRepository;
import me.dio.decola_tech_2025.domain.repository.UserRepository;
import me.dio.decola_tech_2025.dto.like.LikePostRequestDto;
import me.dio.decola_tech_2025.dto.like.LikeDto;
import me.dio.decola_tech_2025.service.LikePostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LikePostServiceImpl implements LikePostService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional
    public LikeDto like(LikePostRequestDto likePostDto) {
        var postFound = this.postRepository.findById(likePostDto.getPostId()).orElseThrow(NoSuchElementException::new);
        var userFound = userRepository.findById(likePostDto.getUserId()).orElseThrow(NoSuchElementException::new);
        Like like = new Like();
        like.setPost(postFound);
        like.setUser(userFound);
        like.setComment(null);
        return this.modelMapper.map(likeRepository.save(like), LikeDto.class);
    }

    @Override
    public void unlike(LikePostRequestDto likePostDto) {
        var postFound = this.postRepository.findById(likePostDto.getPostId())
                .orElseThrow(NoSuchElementException::new);

        var userFound = userRepository.findById(likePostDto.getUserId())
                .orElseThrow(NoSuchElementException::new);

        var like = this.likeRepository.findByPostAndUser(postFound, userFound)
                .orElseThrow(() -> new NoSuchElementException("Like not found"));

        this.likeRepository.delete(like);

    }
}
