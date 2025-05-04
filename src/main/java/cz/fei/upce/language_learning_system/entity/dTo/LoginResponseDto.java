package cz.fei.upce.language_learning_system.entity.dTo;

import lombok.AllArgsConstructor;
import lombok.Data;

// Login response by měla vracet pouze JWT token!
// Je už zbytečné aby vracela uživatelské jméno, protože to uživatel zná.
// Vracet heslo je navíc i bezpečnostní riziko. I kdyby bylo hashované, nikdy nemělo opustit backend!
@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String token;
}
