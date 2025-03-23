package me.dio.decola_tech_2025.domain.repository;

import me.dio.decola_tech_2025.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    boolean existsByAccountNumber(String accountNumber);
}
