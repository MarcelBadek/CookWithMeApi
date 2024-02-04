package org.example.cookwithmeapi.repository.implementation;

import org.example.cookwithmeapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepositoryImpl extends JpaRepository<Category, UUID> {
}
