package com.example.business.services.impl;

import com.example.business.services.AuthService;
import com.example.core.dtos.requests.LoginRequest;
import com.example.core.dtos.requests.RegisterRequest;
import com.example.core.dtos.responses.AuthResponse;
import com.example.core.exceptions.AuthenticationException;
import com.example.core.security.JwtUtils;
import com.example.entities.concretes.Role;
import com.example.entities.concretes.User;
import com.example.entities.enums.RoleType;
import com.example.repository.abstracts.RoleRepository;
import com.example.repository.abstracts.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new AuthenticationException("Email address has been taken already");
        }

        Role studentRole = roleRepository.findByName(RoleType.ROLE_STUDENT)
                .orElseGet(() -> {
                    Role newRole = new Role();
                    newRole.setName(RoleType.ROLE_STUDENT);
                    return roleRepository.save(newRole);
                });

        Set<Role> roles = new HashSet<>();
        roles.add(studentRole);

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(roles)
                .isActive(true)
                .build();

        userRepository.save(user);

        String token = jwtUtils.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .message("Register successfully")
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new AuthenticationException("Email or password is not valid");
        }

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AuthenticationException("User not found"));

        String token = jwtUtils.generateToken(user);

        return AuthResponse.builder()
                .token(token)
                .message("Login successfully")
                .build();
    }
}
