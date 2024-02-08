package org.example.cookwithmeapi.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.cookwithmeapi.exceptions.NotFoundException;
import org.example.cookwithmeapi.exceptions.message.AccountExceptionMessage;
import org.example.cookwithmeapi.repository.implementation.ClientRepositoryImpl;
import org.example.cookwithmeapi.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ClientRepositoryImpl clientRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return clientRepository.findByUsername(username).orElseThrow(() -> new NotFoundException(AccountExceptionMessage.NOT_FOUND_BY_USERNAME));
            }
        };
    }
}
