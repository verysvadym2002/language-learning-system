package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.dto.KartickaRequestDto;
import cz.fei.upce.language_learning_system.entity.Karticka;
import cz.fei.upce.language_learning_system.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cards")
public class CardController {

    // Správný název atributu
    private final CardService cardService;

    // Správný název endpointu. Rest API by mělo mít jednotný styl. Není potřeba uvádět název operace (např. "cards, update").
    // Název operace je implicitně dán HTTP metodou (GET pro čteni, POST pro vytvoření záznamu, PUT pro update, DELETE pro mazání).
    // Každá metoda která reprezentuje endpoint by měla vracet ResponseEntity<?>.
    // to Vám umožňuje definovat HTTP status kód a zároveň vás neomezí ve vracení dat.
    // https://medium.com/@syedabdullahrahman/mastering-rest-api-design-essential-best-practices-dos-and-don-ts-for-2024-dd41a2c59133
    @GetMapping("/")
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(
                cardService.findAll()
                        // Streamy umožňují elegantně zpracovávat kolekce dat.
                        // Metoda map překonvertuje každou honotu v listu na DTO.
                        // https://www.geeksforgeeks.org/stream-map-java-examples/
                        .stream()
                        // Best practice: nevracet přímo entitu, ale DTO. Umožní Vám to kontrolovat která data se
                        // pošlou zpět klientovi. A nestane se že pošlete něco co nemáte.
                        .map(k -> k.toResponseDto())
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.findById(id).toResponseDto());
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCard(@RequestBody KartickaRequestDto karticka) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(cardService.save(karticka.toRequestDto()));
    }

    // Chyběli endpoity pro update a delete

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCard(@PathVariable Long id, @RequestBody KartickaRequestDto karticka) {
        return ResponseEntity.ok(cardService.update(id, karticka));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCard(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
