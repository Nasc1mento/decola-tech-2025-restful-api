package me.dio.decola_tech_2025.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.domain.model.User;
import me.dio.decola_tech_2025.domain.repository.UserRepository;
import me.dio.decola_tech_2025.dto.user.UserCreateDto;
import me.dio.decola_tech_2025.dto.user.UserDto;
import me.dio.decola_tech_2025.dto.user.UserUpdateDto;
import me.dio.decola_tech_2025.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper modelMapper;


    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        var userFound = this.repository.findById(id).orElseThrow(NoSuchElementException::new);
        return this.modelMapper.map(userFound, UserDto.class);
    }

    @Override
    public UserDto create(UserCreateDto u) {
        var userCreated = this.repository.save(modelMapper.map(u, User.class));
        return this.modelMapper.map(userCreated, UserDto.class);
    }

    @Override
    public void delete(Long id) {
        this.repository.findById(id).orElseThrow(NoSuchElementException::new);
        this.repository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto update(Long id, UserUpdateDto u) {
        var userFound = this.repository.findById(id).orElseThrow(NoSuchElementException::new);
        userFound.setUsername(u.getUsername());
        userFound.setPassword(u.getPassword());
        return this.modelMapper.map(userFound, UserDto.class);
    }
}
