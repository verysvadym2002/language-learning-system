package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.entity.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private final TestRepository repository;

    TestController(TestRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tests")
    List<Test> all() {
        return repository.findAll();
    }
}
