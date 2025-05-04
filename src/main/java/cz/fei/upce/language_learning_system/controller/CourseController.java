package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Kurz> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kurz> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Kurz> createCourse(@RequestBody Kurz kurz) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(kurz));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kurz> updateCourse(@PathVariable Long id, @RequestBody Kurz kurz) {
        kurz.setId(id);
        return ResponseEntity.ok(courseService.update(kurz));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
