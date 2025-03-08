package com.example.webapi;

import com.example.business.services.AuthService;
import com.example.core.dtos.requests.RegisterRequest;
import com.example.core.dtos.responses.AuthResponse;
import com.example.webapi.controller.AuthController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock  // @MockBean yerine doğrudan Mockito mock objesi oluşturuyoruz
    private AuthService authService;

    @InjectMocks  // AuthController'in bağımlılıklarını enjekte eder
    private AuthController authController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testRegister() throws Exception {
        RegisterRequest request = new RegisterRequest("John", "Doe", "0537704", "password123","John","john@example.com","123456");
        AuthResponse response = new AuthResponse("mocked-token", "Register successfully");

        // Mock davranışını ayarla
        Mockito.when(authService.register(Mockito.any(RegisterRequest.class))).thenReturn(response);

        // HTTP isteğini gönder ve sonucu doğrula
        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("mocked-token"))
                .andExpect(jsonPath("$.message").value("Register successfully"));
    }
}
