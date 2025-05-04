package cz.fei.upce.language_learning_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UzivatelResponseDto {
    private Long id;
    private String userName;
    private String email;
}
