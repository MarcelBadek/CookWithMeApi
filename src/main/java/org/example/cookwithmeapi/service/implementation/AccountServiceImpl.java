package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cookwithmeapi.exceptions.DataUniquenessException;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.model.account.Account;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.model.account.Client;
import org.example.cookwithmeapi.repository.AdministratorRepository;
import org.example.cookwithmeapi.repository.ClientRepository;
import org.example.cookwithmeapi.service.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final ClientRepository clientRepository;
    private final AdministratorRepository administratorRepository;

    @Override
    public void checkDataUniqueness(Account account) {
        if (isUsernameAlreadyTaken(account.getUsername())) {
            throw new DataUniquenessException(AccountExceptionMessage.USERNAME_ALREADY_TAKEN);
        }

        if (isEmailAlreadyTaken(account.getEmail())) {
            throw new DataUniquenessException(AccountExceptionMessage.EMAIL_ALREADY_TAKEN);
        }
    }

    @Override
    public boolean isUsernameAlreadyTaken(String username) {
        if (clientRepository.findByUsername(username).isPresent()) {
            return true;
        }

        if (administratorRepository.findByUsername(username).isPresent()) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isEmailAlreadyTaken(String email) {
        if (clientRepository.findByEmail(email).isPresent()) {
            return true;
        }

        if (administratorRepository.findByEmail(email).isPresent()) {
            return true;
        }

        return false;
    }

    @Override
    public Account getAccountByUsername(String username) {
        Optional<Client> client = clientRepository.findByUsername(username);
        if (client.isPresent()) return client.get();

        Optional<Administrator> administrator = administratorRepository.findByUsername(username);
        if (administrator.isPresent()) return administrator.get();

        throw new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<Client> client = clientRepository.findByUsername(username);
                if (client.isPresent()) return client.get();

                Optional<Administrator> administrator = administratorRepository.findByUsername(username);
                if (administrator.isPresent()) return administrator.get();

                throw new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME);
            }
        };
    }
}
