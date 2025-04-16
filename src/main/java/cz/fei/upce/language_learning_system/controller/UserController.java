package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Uzivatel;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List<Uzivatel> all() {
        return repository.findAll();
    }

}
