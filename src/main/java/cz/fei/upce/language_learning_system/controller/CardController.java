package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.KartickaRequestDto;
import cz.fei.upce.language_learning_system.dto.KartickaResponseDto;
import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @GetMapping
    public ResponseEntity<List<KartickaResponseDto>> getCardsByCourse(@RequestParam(required = false) Long courseId) {
        List<Karticka> cards = cardService.findAll();
        if (courseId != null) {
            cards = cards.stream()
                    .filter(card -> card.getCourse().getId().equals(courseId))
                    .collect(Collectors.toList());
        }
        List<KartickaResponseDto> response = cards.stream()
                .map(Karticka::toResponseDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KartickaResponseDto> getCardById(@PathVariable Long id) {
        Karticka card = cardService.findById(id);
        return ResponseEntity.ok(card.toResponseDto());
    }

    @PostMapping
    public ResponseEntity<KartickaResponseDto> saveCard(@RequestBody KartickaRequestDto kartickaRequestDto) {
        Karticka savedCard = cardService.save(kartickaRequestDto.toRequestDto());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCard.toResponseDto());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KartickaResponseDto> updateCard(@PathVariable Long id, @RequestBody KartickaRequestDto kartickaRequestDto) {
        Karticka updatedCard = cardService.update(id, kartickaRequestDto);
        return ResponseEntity.ok(updatedCard.toResponseDto());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
