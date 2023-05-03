package com.blablaeda.deliverybackend.service.product;

import com.blablaeda.deliverybackend.dto.DishCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.product.Dish;

public interface DishService {
    Dish save(DishCreateDto dishCreateDto);
    Dish findById(Long id);
}
