package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.repository.ClientRepository;
import org.example.cookwithmeapi.service.AccountService;
import org.example.cookwithmeapi.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Override
    public List<Client> get() {
        return repository.findAll();
    }

    @Override
    public Client getById(UUID id) {
        Optional<Client> result = repository.findById(id);

        if(result.isEmpty()) throw new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_ID);

        return result.get();
    }

    @Override
    public Client getByUsername(String username) {
        Optional<Client> result = repository.findByUsername(username);

        if(result.isEmpty()) throw new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME);

        return result.get();
    }

    @Override
    public Client getByEmail(String email) {
        Optional<Client> result = repository.findByEmail(email);

        if(result.isEmpty()) throw new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_EMAIL);

        return result.get();
    }

    @Override
    public Client create(Client client) {
        accountService.checkDataUniqueness(client);

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return repository.saveAndFlush(client);
    }

    @Override
    public Client update(UUID id, Client client) {
        Client result = repository.findById(id).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_ID));

        result.setFirstName(client.getFirstName());
        result.setLastName(client.getLastName());

        return repository.saveAndFlush(result);
    }
}
