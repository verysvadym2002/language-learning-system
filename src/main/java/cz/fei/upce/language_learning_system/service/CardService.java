package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CardService {
    private final CardRepository cardRepository;

    public List<Karticka> findAll() {
        return cardRepository.findAll();
    }

    public Karticka findById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public Karticka save(Karticka karticka) {
        return cardRepository.save(karticka);
    }

    public Karticka update(Karticka karticka) {
        Karticka existentCard = cardRepository.findById(karticka.getId())
                .orElseThrow(() -> new RuntimeException("Card not found"));
        existentCard.setCourse(karticka.getCourse());
        existentCard.setUzivatel(karticka.getUzivatel());
        existentCard.setTitle(karticka.getTitle());
        existentCard.setDescription(karticka.getDescription());
        return cardRepository.save(karticka);
    }

    public void delete(Long id) {
        Karticka existentCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        cardRepository.delete(existentCard);
    }
}
