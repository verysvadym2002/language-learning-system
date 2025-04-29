package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    public List<Kurz> findAll() {
        return courseRepository.findAll();
    }

    public Kurz findById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Kurz save(Kurz kurz) {
        return courseRepository.save(kurz);
    }

    public Kurz update(Kurz kurz) {
        Kurz existentCourse = courseRepository.findById(kurz.getId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        existentCourse.setLanguage(kurz.getLanguage());
        existentCourse.setDescription(kurz.getDescription());
        existentCourse.setUsers(kurz.getUsers());
        existentCourse.setCards(kurz.getCards());
        existentCourse.setTests(kurz.getTests());
        return courseRepository.save(existentCourse);
    }

    public void delete(Long id) {
        Kurz existentCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(existentCourse);
    }
}
