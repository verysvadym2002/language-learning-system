package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository repository;

    @GetMapping("/users")
    List<Uzivatel> all() {
        return repository.findAll();
    }

}
