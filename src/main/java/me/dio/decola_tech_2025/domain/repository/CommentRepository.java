package me.dio.decola_tech_2025.domain.repository;

import me.dio.decola_tech_2025.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> { }
