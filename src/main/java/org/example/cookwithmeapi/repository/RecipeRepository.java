package org.example.cookwithmeapi.repository;

import org.example.cookwithmeapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
    List<Recipe> findAllByAuthorId(UUID id);
}
