package com.blablaeda.deliverybackend.postgres.repository.product;

import com.blablaeda.deliverybackend.postgres.entity.product.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> findByName(String name);
}
