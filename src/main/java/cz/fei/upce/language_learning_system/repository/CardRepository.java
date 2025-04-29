package cz.fei.upce.language_learning_system.repository;

import cz.fei.upce.language_learning_system.entity.Karticka;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Karticka, Long> {

}
