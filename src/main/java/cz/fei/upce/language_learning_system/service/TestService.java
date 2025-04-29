package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.entity.Test;
import cz.fei.upce.language_learning_system.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository testRepository;

    public List<Test> findAll() {
        return testRepository.findAll();
    }

    public Test findById(Long id) {
        return testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found"));
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public Test update(Test test) {
        Test existentTest = testRepository.findById(test.getId())
                .orElseThrow(() -> new RuntimeException("Test not found"));
        existentTest.setTopic(test.getTopic());
        existentTest.setUsers(test.getUsers());
        existentTest.setCourse(test.getCourse());
        return testRepository.save(existentTest);
    }

    public void delete(Long id) {
        Test existentTest = testRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found"));
        testRepository.delete(existentTest);
    }
}
