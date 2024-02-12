package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface AdministratorController {
    ResponseEntity<List<AccountResponse>> get();
    ResponseEntity<AccountResponse> getById(UUID id);
    ResponseEntity<AccountResponse> getByUsername(String username);
    ResponseEntity<AccountResponse> getByEmail(String email);
    ResponseEntity<AccountResponse> create(AccountRegisterRequest request);
    ResponseEntity<AccountResponse> update(UUID id, AccountUpdateRequest request);
}
