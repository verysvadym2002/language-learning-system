package cz.fei.upce.language_learning_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurzResponseDto {
    private Long id;
    private String language;
    private String description;
}
