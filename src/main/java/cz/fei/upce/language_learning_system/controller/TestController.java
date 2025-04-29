package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Test;
import cz.fei.upce.language_learning_system.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final TestRepository repository;

    @GetMapping("/tests")
    List<Test> all() {
        return repository.findAll();
    }
}
