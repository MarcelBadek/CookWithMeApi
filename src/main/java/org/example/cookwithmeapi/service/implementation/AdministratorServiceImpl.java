package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.repository.AdministratorRepository;
import org.example.cookwithmeapi.service.AccountService;
import org.example.cookwithmeapi.service.AdministratorService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdministratorServiceImpl implements AdministratorService {
    private final AdministratorRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AccountService accountService;

    @Override
    public List<Administrator> get() {
        return repository.findAll();
    }

    @Override
    public Administrator getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_ID));
    }

    @Override
    public Administrator getByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME));
    }

    @Override
    public Administrator getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_EMAIL));
    }

    @Override
    public Administrator create(Administrator administrator) {
        accountService.checkDataUniqueness(administrator);

        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        return repository.saveAndFlush(administrator);
    }

    @Override
    public Administrator update(UUID id, Administrator administrator) {
        Administrator result = repository.findById(id).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_ID));

        result.setFirstName(administrator.getFirstName());
        result.setLastName(administrator.getLastName());

        return repository.saveAndFlush(result);
    }
}
