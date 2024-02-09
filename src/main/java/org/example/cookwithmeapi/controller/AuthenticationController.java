package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.dto.authentication.LoginRequest;
import org.example.cookwithmeapi.model.account.Client;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
     ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);
     ResponseEntity<Client> register(AccountRegisterRequest registerRequest);
}
