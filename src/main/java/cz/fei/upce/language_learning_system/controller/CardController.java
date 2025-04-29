package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.repository.CardRepository;
import cz.fei.upce.language_learning_system.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService repository;

    @GetMapping("/cards")
    public List<Karticka> all() {
        return repository.findAll();
    }

    @GetMapping("/cards/{id}")
    public Karticka getCardById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PostMapping("/save")
    public Karticka saveCard(@RequestBody Karticka karticka) {
        return repository.save(karticka);
    }

}
