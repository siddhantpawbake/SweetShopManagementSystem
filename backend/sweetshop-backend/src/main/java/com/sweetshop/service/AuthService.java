package com.sweetshop.service;

import com.sweetshop.domain.User;
import com.sweetshop.dto.AuthRequest;
import com.sweetshop.repository.UserRepository;
import com.sweetshop.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(AuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                "ROLE_USER"
        );
        userRepository.save(user);
    }

    public String login(AuthRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username/password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username/password");
        }

        return jwtService.generateToken(user.getUsername(), user.getRole());
    }
}
