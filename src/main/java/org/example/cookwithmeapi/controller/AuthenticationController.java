package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.model.dto.authentication.AccountRegisterRequest;
import org.example.cookwithmeapi.model.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.model.dto.authentication.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
     ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);
     ResponseEntity<AuthenticationResponse> register(AccountRegisterRequest registerRequest);
}
