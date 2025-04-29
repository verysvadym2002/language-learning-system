package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Uzivatel> findAll() {
        return userRepository.findAll();
    }

    public Uzivatel findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Uzivatel save(Uzivatel uzivatel) {
        return userRepository.save(uzivatel);
    }

    public Uzivatel update(Uzivatel uzivatel) {
        Uzivatel existentUser = userRepository.findById(uzivatel.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        existentUser.setUserName(uzivatel.getUsername());
        existentUser.setEmail(uzivatel.getEmail());
        existentUser.setPassword(uzivatel.getPassword());
        existentUser.setCourses(uzivatel.getCourses());
        existentUser.setTests(uzivatel.getTests());
        existentUser.setCards(uzivatel.getCards());
        return userRepository.save(existentUser);
    }

    public void delete(Long id) {
        Uzivatel existentUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(existentUser);
    }
}
