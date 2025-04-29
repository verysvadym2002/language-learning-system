package cz.fei.upce.language_learning_system.controller;


import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository repository;

    @GetMapping("/courses")
    List<Kurz> all() {
        return repository.findAll();
    }
}
