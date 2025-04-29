package cz.fei.upce.language_learning_system.repository;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Uzivatel, Long> {
public Optional<Uzivatel> findByUserName(String username);
}