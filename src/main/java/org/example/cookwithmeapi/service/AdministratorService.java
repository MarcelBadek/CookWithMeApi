package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.account.Administrator;

import java.util.List;
import java.util.UUID;

public interface AdministratorService {
    List<Administrator> get();
    Administrator getById(UUID id);
    Administrator getByUsername(String username);
    Administrator getByEmail(String email);
    Administrator create(Administrator administrator);
    Administrator update(UUID id, Administrator administrator);
}
