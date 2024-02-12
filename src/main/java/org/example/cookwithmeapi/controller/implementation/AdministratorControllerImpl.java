package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.AdministratorController;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.example.cookwithmeapi.mapper.AccountMapper;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.service.AdministratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdministratorControllerImpl implements AdministratorController {
    private final AdministratorService service;

    @GetMapping
    @Override
    public ResponseEntity<List<AccountResponse>> get() {
        List<Administrator> response = service.get();

        return ResponseEntity.status(HttpStatus.OK).body(response.stream().map(AccountMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AccountResponse> getById(@PathVariable UUID id) {
        Administrator response = service.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @GetMapping("/username/{username}")
    @Override
    public ResponseEntity<AccountResponse> getByUsername(@PathVariable String username) {
        Administrator response = service.getByUsername(username);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @GetMapping("/email/{email}")
    @Override
    public ResponseEntity<AccountResponse> getByEmail(@PathVariable String email) {
        Administrator response = service.getByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @PostMapping
    @Override
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountRegisterRequest request) {
        Administrator response = service.create(AccountMapper.toAdministrator(request));

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<AccountResponse> update(@PathVariable UUID id, @Valid @RequestBody AccountUpdateRequest request) {
        Administrator response = service.update(id, AccountMapper.toAdministrator(request));

        return ResponseEntity.status(HttpStatus.OK).body(AccountMapper.toResponse(response));
    }
}
