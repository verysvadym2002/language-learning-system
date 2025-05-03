package cz.fei.upce.language_learning_system.entity;

import cz.fei.upce.language_learning_system.dto.KartickaResponseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Karticka {
    @Id
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private Kurz course;

    @ManyToOne
    private Uzivatel uzivatel;

    // Pomocná metoda pro převod entity na DTO
    // Díky této metodě můžete snadno převést entitu na DTO v kódu: k.toResponseDto()
    public KartickaResponseDto toResponseDto() {
        return new KartickaResponseDto(
                id,
                title,
                description
        );
    }
}
