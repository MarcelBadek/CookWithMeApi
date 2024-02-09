package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.account.Account;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.dto.authentication.LoginRequest;
import org.example.cookwithmeapi.repository.ClientRepository;
import org.example.cookwithmeapi.service.AccountService;
import org.example.cookwithmeapi.service.AuthenticationService;
import org.example.cookwithmeapi.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ClientRepository clientRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Account account = accountService.getAccountByUsername(request.getUsername());
        String jwt = jwtService.generateToken(account);
        return new AuthenticationResponse(jwt);
    }

    @Override
    public AuthenticationResponse register(AccountRegisterRequest request) {
        Client client = Client
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        client = clientRepository.saveAndFlush(client);
        String token = jwtService.generateToken(client);
        return new AuthenticationResponse(token);
    }


}
