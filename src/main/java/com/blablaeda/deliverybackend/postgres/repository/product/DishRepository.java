package com.blablaeda.deliverybackend.postgres.repository.product;

import com.blablaeda.deliverybackend.postgres.entity.product.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
