package cz.fei.upce.language_learning_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// Pomocné DTO pro přenos dat mezi klientem a serverem
// Entity by neměla být použity jako response body endpointů.
// Entity slouží pouze pro práci s databází.
@Data
@AllArgsConstructor
public class KartickaResponseDto {
    private Long id;
    private String title;
    private String description;
}

