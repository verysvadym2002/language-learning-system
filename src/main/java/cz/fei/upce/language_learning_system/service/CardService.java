package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.dto.KartickaRequestDto;
import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CardService {
    private final CardRepository cardRepository;

    // Metody které využívají databázi opatřit anotací @Transactional
    // Pokud jsou data z databáze pouze pro čtení, použít @Transactional(readOnly = true)
    @Transactional(readOnly = true)
    public List<Karticka> findAll() {
        return cardRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Karticka findById(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
    }

    @Transactional
    public Karticka save(Karticka karticka) {
        return cardRepository.save(karticka);
    }

    // Přidána metoda pro update
    @Transactional
    public Karticka update(Long id, KartickaRequestDto karticka) {
        Karticka existentCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        existentCard.setTitle(karticka.getTitle());
        existentCard.setDescription(karticka.getDescription());

        return cardRepository.save(existentCard);
    }

    @Transactional
    public Karticka update(Karticka karticka) {
        return cardRepository.save(karticka);
    }

    @Transactional
    public void delete(Long id) {
        Karticka existentCard = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        cardRepository.delete(existentCard);
    }
}
