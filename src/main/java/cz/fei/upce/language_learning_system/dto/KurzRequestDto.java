package cz.fei.upce.language_learning_system.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class KurzRequestDto {
    @NotBlank(message = "Language cannot be blank")
    @Size(max = 50, message = "Language must be less than 50 characters")
    private String language;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;
}