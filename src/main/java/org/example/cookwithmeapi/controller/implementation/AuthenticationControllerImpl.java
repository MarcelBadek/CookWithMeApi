package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.controller.AuthenticationController;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.dto.authentication.LoginRequest;
import org.example.cookwithmeapi.mapper.AccountMapper;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.service.AuthenticationService;
import org.example.cookwithmeapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthenticationService service;
    private final ClientService clientService;
    @PostMapping("/login")
    @Override
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AuthenticationResponse response = service.login(loginRequest);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/register")
    @Override
    public ResponseEntity<AccountResponse> register(@Valid @RequestBody AccountRegisterRequest registerRequest) {
        Client response = clientService.create(AccountMapper.toClient(registerRequest));
        
        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }
}
