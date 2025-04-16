package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Karticka;
import org.springframework.data.jpa.repository.JpaRepository;

interface CardRepository extends JpaRepository<Karticka, Long> {

}
