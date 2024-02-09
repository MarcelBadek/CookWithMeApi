package org.example.cookwithmeapi.mapper;

import org.example.cookwithmeapi.dto.account.AccountRegisterRequest;
import org.example.cookwithmeapi.dto.account.AccountUpdateRequest;
import org.example.cookwithmeapi.model.account.Administrator;
import org.example.cookwithmeapi.model.account.Client;

public class AccountMapper {
    public static Administrator toAdministrator(AccountRegisterRequest request) {
        return Administrator
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
    }

    public static Administrator toAdministrator(AccountUpdateRequest request) {
        return Administrator
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }

    public static Client toClient(AccountRegisterRequest request) {
        return Client
                .builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .build();
    }

    public static Client toClient(AccountUpdateRequest request) {
        return Client
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
    }
}
