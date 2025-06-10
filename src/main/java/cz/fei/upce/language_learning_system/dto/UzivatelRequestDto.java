package cz.fei.upce.language_learning_system.dto;

import cz.fei.upce.language_learning_system.entity.Role;
import lombok.Data;

@Data
public class UzivatelRequestDto {
    private String userName;
    private String email;
    private String password;
    private Role role;
}
