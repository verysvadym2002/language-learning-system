package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.KurzRequestDto;
import cz.fei.upce.language_learning_system.dto.KurzResponseDto;
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
    public ResponseEntity<KurzResponseDto> createCourse(@RequestBody KurzRequestDto courseRequestDto) {
        Kurz course = new Kurz();
        course.setLanguage(courseRequestDto.getLanguage());
        course.setDescription(courseRequestDto.getDescription());
        Kurz savedCourse = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse.toResponseDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KurzResponseDto> updateCourse(@PathVariable Long id, @RequestBody KurzRequestDto courseRequestDto) {
        Kurz course = new Kurz();
        course.setId(id);
        course.setLanguage(courseRequestDto.getLanguage());
        course.setDescription(courseRequestDto.getDescription());
        Kurz updatedCourse = courseService.update(course);
        return ResponseEntity.ok(updatedCourse.toResponseDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
