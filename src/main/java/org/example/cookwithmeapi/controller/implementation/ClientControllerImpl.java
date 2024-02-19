package org.example.cookwithmeapi.controller.implementation;

import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.ClientController;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.example.cookwithmeapi.mapper.AccountMapper;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientControllerImpl implements ClientController {
    private final ClientService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<List<AccountResponse>> get() {
        List<Client> response = service.get();

        return ResponseEntity.status(HttpStatus.OK).body(response.stream().map(AccountMapper::toResponse).toList());
    }

    @GetMapping("/me")
    @Override
    public ResponseEntity<AccountResponse> getSelf() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client response = service.getByUsername(auth.getName());

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<AccountResponse> getById(@PathVariable UUID id) {
        Client response = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @GetMapping("/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<AccountResponse> getByUsername(@PathVariable String username) {
        Client response = service.getByUsername(username);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @GetMapping("/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public ResponseEntity<AccountResponse> getByEmail(@PathVariable String email) {
        Client response = service.getByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @PutMapping()
    @Override
    public ResponseEntity<AccountResponse> update(@RequestBody AccountUpdateRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Client client = service.getByUsername(auth.getName());
        Client response = service.update(client.getId(), AccountMapper.toClient(request));

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }
}
