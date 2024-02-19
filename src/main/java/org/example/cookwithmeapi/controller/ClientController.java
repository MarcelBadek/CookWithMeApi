package org.example.cookwithmeapi.controller;

import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.account.AccountResponse;
import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ClientController {
    ResponseEntity<List<AccountResponse>> get();
    ResponseEntity<AccountResponse> getSelf();
    ResponseEntity<AccountResponse> getById(UUID id);
    ResponseEntity<AccountResponse> getByUsername(String username);
    ResponseEntity<AccountResponse> getByEmail(String email);
    ResponseEntity<AccountResponse> update(AccountUpdateRequest request);
}
