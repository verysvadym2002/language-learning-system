package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.UzivatelRequestDto;
import cz.fei.upce.language_learning_system.dto.UzivatelResponseDto;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<Uzivatel> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Uzivatel> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UzivatelResponseDto> createUser(@RequestBody UzivatelRequestDto userRequestDto) {
        Uzivatel user = new Uzivatel();
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        Uzivatel savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser.toResponseDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UzivatelResponseDto> updateUser(@PathVariable Long id, @RequestBody UzivatelRequestDto userRequestDto) {
        Uzivatel user = new Uzivatel();
        user.setId(id);
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        Uzivatel updatedUser = userService.update(user);
        return ResponseEntity.ok(updatedUser.toResponseDto());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
