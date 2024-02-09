package org.example.cookwithmeapi.repository;

import org.example.cookwithmeapi.model.account.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AdministratorRepository extends JpaRepository<Administrator, UUID> {
    Optional<Administrator> findByUsername(String username);
    Optional<Administrator> findByEmail(String email);
}
