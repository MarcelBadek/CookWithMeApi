package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.model.dto.authentication.LoginRequest;

public interface AuthenticationService {
    public AuthenticationResponse login(LoginRequest loginRequest);
}
