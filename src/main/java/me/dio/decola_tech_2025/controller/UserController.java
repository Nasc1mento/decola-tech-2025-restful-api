package me.dio.decola_tech_2025.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.dio.decola_tech_2025.dto.user.UserCreateDto;
import me.dio.decola_tech_2025.dto.user.UserDto;
import me.dio.decola_tech_2025.dto.user.UserUpdateDto;
import me.dio.decola_tech_2025.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserCreateDto user) {
        var userCreated = userService.create(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        var userFound = userService.findById(id);
        return ResponseEntity.ok(userFound);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDto user) {
        var userUpdated = this.userService.update(id,user);
        return ResponseEntity.ok(userUpdated);
    }
}
