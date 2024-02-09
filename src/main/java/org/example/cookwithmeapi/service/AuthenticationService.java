package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.dto.authentication.LoginRequest;

public interface AuthenticationService {
    AuthenticationResponse login(LoginRequest request);
    AuthenticationResponse register(AccountRegisterRequest request);
}
