package org.example.cookwithmeapi.controller.implementation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.cookwithmeapi.controller.AdministratorController;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
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
    public ResponseEntity<List<Administrator>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(service.get());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Administrator> getById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @GetMapping("/username/{username}")
    @Override
    public ResponseEntity<Administrator> getByUsername(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getByUsername(username));
    }

    @GetMapping("/email/{email}")
    @Override
    public ResponseEntity<Administrator> getByEmail(@PathVariable String email) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getByEmail(email));
    }

    @PostMapping
    @Override
    public ResponseEntity<Administrator> create(@Valid @RequestBody AccountRegisterRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.create(AccountMapper.toAdministrator(request)));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Administrator> update(@PathVariable UUID id, @Valid @RequestBody AccountUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.create(AccountMapper.toAdministrator(request)));
    }
}
