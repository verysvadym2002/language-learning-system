package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.dto.KurzRequestDto;
import cz.fei.upce.language_learning_system.dto.KurzResponseDto;
import cz.fei.upce.language_learning_system.entity.Kurz;
import cz.fei.upce.language_learning_system.mapper.CourseMapper;
import cz.fei.upce.language_learning_system.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<KurzResponseDto> findAll() {
        logger.info("Fetching all courses");
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .collect(Collectors.toList());
    }

    public Page<KurzResponseDto> findAll(Pageable pageable) {
        logger.info("Fetching paged courses with pageable: {}", pageable);
        return courseRepository.findAll(pageable)
                .map(courseMapper::toDto);
    }

    public KurzResponseDto findById(Long id) {
        logger.info("Fetching course by ID: {}", id);
        Kurz kurz = courseRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Course not found with ID: {}", id);
                    return new RuntimeException("Course not found");
                });
        return courseMapper.toDto(kurz);
    }

    public KurzResponseDto save(KurzRequestDto kurzRequestDto) {
        logger.info("Saving course: {}", kurzRequestDto.getLanguage());
        Kurz kurz = courseMapper.toEntity(kurzRequestDto);
        return courseMapper.toDto(courseRepository.save(kurz));
    }

    public KurzResponseDto update(KurzRequestDto kurzRequestDto, Long id) {
        logger.info("Updating course with ID: {}", id);
        Kurz existentCourse = courseRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Course not found with ID: {}", id);
                    return new RuntimeException("Course not found");
                });
        existentCourse.setLanguage(kurzRequestDto.getLanguage());
        existentCourse.setDescription(kurzRequestDto.getDescription());
        return courseMapper.toDto(courseRepository.save(existentCourse));
    }

    public void delete(Long id) {
        logger.info("Deleting course with ID: {}", id);
        Kurz existentCourse = courseRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Course not found with ID: {}", id);
                    return new RuntimeException("Course not found");
                });
        courseRepository.delete(existentCourse);
    }
}
