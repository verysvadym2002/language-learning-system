package cz.fei.upce.language_learning_system.dto;

import cz.fei.upce.language_learning_system.entity.Karticka;
import lombok.AllArgsConstructor;
import lombok.Data;

// Pomocné DTO pro přenos dat mezi klientem a serverem
// Entity by neměla být použity jako request body endpointů.
// Entity slouží pouze pro práci s databází.
@Data
@AllArgsConstructor
public class KartickaRequestDto {
    private String title;
    private String description;

    public Karticka toRequestDto() {
        Karticka karticka = new Karticka();
        karticka.setTitle(title);
        karticka.setDescription(description);
        return karticka;
    }
}
