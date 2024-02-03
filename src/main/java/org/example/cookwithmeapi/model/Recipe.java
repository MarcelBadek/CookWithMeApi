package org.example.cookwithmeapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.cookwithmeapi.model.account.Client;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private int preparationTime;

    private String ingredients;

    private String description;

    @ManyToMany
    private List<Category> categories;

    @ManyToOne
    private Client author;
}
