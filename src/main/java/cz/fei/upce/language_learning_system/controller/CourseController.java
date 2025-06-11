package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.KurzRequestDto;
import cz.fei.upce.language_learning_system.dto.KurzResponseDto;
import cz.fei.upce.language_learning_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<KurzResponseDto> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<KurzResponseDto>> getCourses(Pageable pageable) {
        Page<KurzResponseDto> courses = courseService.findAll(pageable);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KurzResponseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<KurzResponseDto> createCourse(@RequestBody KurzRequestDto courseRequestDto) {
        KurzResponseDto savedCourse = courseService.save(courseRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KurzResponseDto> updateCourse(@PathVariable Long id, @RequestBody KurzRequestDto courseRequestDto) {
        KurzResponseDto updatedCourse = courseService.update(courseRequestDto, id);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}