package cz.fei.upce.language_learning_system.controller;


import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private final CourseRepository repository;

    CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/courses")
    List<Kurz> all() {
        return repository.findAll();
    }
}
