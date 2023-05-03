package com.blablaeda.deliverybackend.postgres.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishIngredients {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Dish dish;
    @ManyToOne(fetch = FetchType.LAZY)
    private Ingredient ingredient;
    private Float gramsNumber;

    public DishIngredients(Dish dish, Ingredient ingredient, Float gramsNumber) {
        this.dish = dish;
        this.ingredient = ingredient;
        this.gramsNumber = gramsNumber;
    }
}
