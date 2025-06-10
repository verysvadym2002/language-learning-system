package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.UzivatelRequestDto;
import cz.fei.upce.language_learning_system.dto.UzivatelResponseDto;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UzivatelResponseDto>> getAllUsers() {
        List<UzivatelResponseDto> users = userService.findAll().stream()
                .map(Uzivatel::toResponseDto)
                .toList();
        return ResponseEntity.ok(users);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UzivatelResponseDto> getUserById(@PathVariable Long id) {
        Uzivatel user = userService.findById(id);
        return ResponseEntity.ok(user.toResponseDto());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UzivatelResponseDto> createUser(@RequestBody UzivatelRequestDto userRequestDto) {
        Uzivatel user = new Uzivatel();
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(userRequestDto.getRole());
        Uzivatel savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser.toResponseDto());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<UzivatelResponseDto> updateUser(@PathVariable Long id, @RequestBody UzivatelRequestDto userRequestDto) {
        Uzivatel user = new Uzivatel();
        user.setId(id);
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setRole(userRequestDto.getRole());
        Uzivatel updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser.toResponseDto());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
