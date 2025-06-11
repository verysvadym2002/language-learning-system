package cz.fei.upce.language_learning_system.service;

import cz.fei.upce.language_learning_system.entity.Role;
import cz.fei.upce.language_learning_system.entity.Uzivatel;
import cz.fei.upce.language_learning_system.entity.dTo.LoginUserDto;
import cz.fei.upce.language_learning_system.entity.dTo.RegisterUserDto;
import cz.fei.upce.language_learning_system.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Uzivatel signup(RegisterUserDto input) {
        Uzivatel user = new Uzivatel();
        user.setUserName(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(Role.USER);

        return userRepository.save(user);
    }

    public Uzivatel authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUserName(input.getUsername())
                .orElseThrow();
    }
}