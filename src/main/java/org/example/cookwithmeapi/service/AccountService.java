package org.example.cookwithmeapi.service;

import org.example.cookwithmeapi.model.account.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService {
    void checkDataUniqueness(Account account);
    boolean isUsernameAlreadyTaken(String username);
    boolean isEmailAlreadyTaken(String email);
    Account getAccountByUsername(String username);
    UserDetailsService userDetailsService();
}
