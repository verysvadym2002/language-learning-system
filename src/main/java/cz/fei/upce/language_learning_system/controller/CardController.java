package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.entity.Kurz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

    private final CardRepository repository;

    CardController(CardRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cards")
    List<Karticka> all() {
        return repository.findAll();
    }
}
