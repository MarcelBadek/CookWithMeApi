package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.dto.authentication.AccountRegisterRequest;
import org.example.cookwithmeapi.model.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.model.dto.authentication.LoginRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest request);
    AuthenticationResponse register(AccountRegisterRequest request);
}
