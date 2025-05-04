package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Test;
import cz.fei.upce.language_learning_system.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tests")
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<Test> getAllTests() {
        return testService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Test> getTestById(@PathVariable Long id) {
        return ResponseEntity.ok(testService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Test> createTest(@RequestBody Test test) {
        return ResponseEntity.status(HttpStatus.CREATED).body(testService.save(test));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Test> updateTest(@PathVariable Long id, @RequestBody Test test) {
        test.setId(id);
        return ResponseEntity.ok(testService.update(test));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        testService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
