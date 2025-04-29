package cz.fei.upce.language_learning_system.repository;

import cz.fei.upce.language_learning_system.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}
