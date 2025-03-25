package me.dio.decola_tech_2025.service;

import me.dio.decola_tech_2025.dto.user.UserCreateDto;
import me.dio.decola_tech_2025.dto.user.UserDto;
import me.dio.decola_tech_2025.dto.user.UserUpdateDto;

public interface UserService {

    UserDto findById(Long id);

    UserDto create(UserCreateDto u);

    void delete(Long id);

    UserDto update(Long id, UserUpdateDto u);
}
