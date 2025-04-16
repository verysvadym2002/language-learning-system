package cz.fei.upce.language_learning_system.controller;


import cz.fei.upce.language_learning_system.entity.Kurz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Kurz, Long> {

}
