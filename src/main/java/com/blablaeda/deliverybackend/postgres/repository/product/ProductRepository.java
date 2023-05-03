package com.blablaeda.deliverybackend.postgres.repository.product;

import com.blablaeda.deliverybackend.postgres.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
