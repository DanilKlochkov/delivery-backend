package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class DishCreateDto {
    private String name;
    private String description;
    private List<IngredientCreateDto> ingredients;
}
