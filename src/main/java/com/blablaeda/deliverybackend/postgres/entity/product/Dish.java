package com.blablaeda.deliverybackend.postgres.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dish {
    @Id
    private Long id;
    private String name;
    private String description;
    private LocalDate createDate;
    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL)
    private Set<DishIngredients> ingredients = new HashSet<>();

    public void addIngredient(Ingredient ingredient, Float grams) {
        var dishIngredient = new DishIngredients(this, ingredient, grams);
        ingredients.add(dishIngredient);
    }
}
