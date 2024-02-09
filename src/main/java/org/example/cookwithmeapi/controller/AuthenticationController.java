package org.example.cookwithmeapi.controller;

import org.apache.coyote.Response;
import org.example.cookwithmeapi.model.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.model.dto.authentication.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationController {
    public ResponseEntity<AuthenticationResponse> login(LoginRequest loginRequest);
}
