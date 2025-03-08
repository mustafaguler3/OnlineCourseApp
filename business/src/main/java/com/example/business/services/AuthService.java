package com.example.business.services;

import com.example.core.dtos.requests.LoginRequest;
import com.example.core.dtos.requests.RegisterRequest;
import com.example.core.dtos.responses.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest request);
}
