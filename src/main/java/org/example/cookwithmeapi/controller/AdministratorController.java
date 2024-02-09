package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AdministratorController {
    ResponseEntity<List<Administrator>> get();
    ResponseEntity<Administrator> getById(UUID id);
    ResponseEntity<Administrator> getByUsername(String username);
    ResponseEntity<Administrator> getByEmail(String email);
    ResponseEntity<Administrator> create(AccountRegisterRequest request);
    ResponseEntity<Administrator> update(UUID id, AccountUpdateRequest request);
}
