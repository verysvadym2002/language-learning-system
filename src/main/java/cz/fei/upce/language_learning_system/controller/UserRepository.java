package cz.fei.upce.language_learning_system.controller;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<Uzivatel, Long> {

}