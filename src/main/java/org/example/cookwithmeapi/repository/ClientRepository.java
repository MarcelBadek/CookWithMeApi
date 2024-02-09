package org.example.cookwithmeapi.repository;

import org.example.cookwithmeapi.model.account.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByUsername(String login);
    Optional<Client> findByEmail(String email);
}
