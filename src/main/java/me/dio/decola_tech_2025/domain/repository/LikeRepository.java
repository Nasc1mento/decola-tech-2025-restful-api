package me.dio.decola_tech_2025.domain.repository;

import me.dio.decola_tech_2025.domain.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> { }
