package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.account.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    List<Client> get();
    Client getById(UUID id);
    Client getByUsername(String username);
    Client getByEmail(String email);
    Client create(Client client);
    Client update(UUID id,Client client);
}
