package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.dTo.LoginUserDto;
import cz.fei.upce.language_learning_system.entity.dTo.RegisterUserDto;
import cz.fei.upce.language_learning_system.repository.UserRepository;
import cz.fei.upce.language_learning_system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterUserDto registerUserDto) {
        authService.signup(registerUserDto);
    }

    @PostMapping("/login")
    public void login(@RequestBody LoginUserDto loginUserDto) {
        authService.authenticate(loginUserDto);
    }
}
