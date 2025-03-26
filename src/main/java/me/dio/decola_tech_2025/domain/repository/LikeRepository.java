package me.dio.decola_tech_2025.domain.repository;

import me.dio.decola_tech_2025.domain.model.Like;
import me.dio.decola_tech_2025.domain.model.Post;
import me.dio.decola_tech_2025.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByPostAndUser(Post post, User user);
}
