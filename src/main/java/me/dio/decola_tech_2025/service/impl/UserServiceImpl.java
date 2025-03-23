package me.dio.decola_tech_2025.service.impl;

import jakarta.transaction.Transactional;
import me.dio.decola_tech_2025.domain.model.User;
import me.dio.decola_tech_2025.domain.repository.UserRepository;
import me.dio.decola_tech_2025.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return this.repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    @Transactional
    public User create(User user) {
        if (user.getId() != null && this.repository.existsById(user.getId())) {
            throw  new IllegalArgumentException("This user already exists");
        }

        return this.repository.save(user);
    }
}
