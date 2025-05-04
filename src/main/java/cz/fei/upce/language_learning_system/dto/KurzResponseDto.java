package cz.fei.upce.language_learning_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KurzResponseDto {
    private Long id;
    private String name;
    private String description;
}
