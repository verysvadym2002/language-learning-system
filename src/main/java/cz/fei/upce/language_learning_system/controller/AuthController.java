package cz.fei.upce.language_learning_system.controller;

import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.entity.dTo.LoginResponseDto;
import cz.fei.upce.language_learning_system.entity.dTo.LoginUserDto;
import cz.fei.upce.language_learning_system.entity.dTo.RegisterUserDto;
import cz.fei.upce.language_learning_system.service.AuthService;
import cz.fei.upce.language_learning_system.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDto registerUserDto) {
        Uzivatel user = authService.signup(registerUserDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user.toResponseDto());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDto loginUserDto) {
        Uzivatel user = authService.authenticate(loginUserDto);

        // Odpovědí na úspěšné přihlášení bude JWT token, kterým se následně bude uživatel prokazovat pro další endpointy.
        // Doporučuji si nastudovat jak tento typ autentifikace funguje: https://www.youtube.com/watch?v=7Q17ubqLfaM
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
