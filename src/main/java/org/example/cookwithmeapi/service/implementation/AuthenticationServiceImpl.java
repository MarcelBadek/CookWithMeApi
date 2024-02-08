package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.model.dto.authentication.AuthenticationResponse;
import org.example.cookwithmeapi.model.dto.authentication.LoginRequest;
import org.example.cookwithmeapi.repository.implementation.ClientRepositoryImpl;
import org.example.cookwithmeapi.service.AuthenticationService;
import org.example.cookwithmeapi.service.JwtService;
import org.example.cookwithmeapi.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ClientRepositoryImpl clientRepository;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        Client user = clientRepository.findByUsername(request.getUsername()).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME));
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }
}
