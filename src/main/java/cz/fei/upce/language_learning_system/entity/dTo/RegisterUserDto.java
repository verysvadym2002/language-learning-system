package cz.fei.upce.language_learning_system.entity.dTo;

import lombok.Data;

@Data
public class RegisterUserDto {
   private String userName;
   private String email;
   private String password;

}

