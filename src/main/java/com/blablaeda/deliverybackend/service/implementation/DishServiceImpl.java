package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.DishCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.product.Dish;
import com.blablaeda.deliverybackend.postgres.entity.product.Ingredient;
import com.blablaeda.deliverybackend.postgres.repository.product.DishRepository;
import com.blablaeda.deliverybackend.postgres.repository.product.IngredientRepository;
import com.blablaeda.deliverybackend.service.product.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final IngredientRepository ingredientRepository;

    @Override
    public Dish save(DishCreateDto dishCreateDto) {
        var dish = dishRepository.save(
                Dish.builder()
                        .name(dishCreateDto.getName())
                        .description(dishCreateDto.getDescription())
                        .createDate(LocalDate.now())
                        .build()
        );
        dishCreateDto.getIngredients().forEach(x ->
            dish.addIngredient(
                    addIngredient(x.getName()),
                    x.getGramsNumber()
            )
        );
        return dishRepository.save(dish);
    }

    private Ingredient addIngredient(String name) {
        return ingredientRepository
                .findByName(name)
                .orElse(ingredientRepository.save(
                        Ingredient.builder()
                                .name(name)
                                .build()
                ));
    }

    @Override
    public Dish findById(Long id) {
        return dishRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
