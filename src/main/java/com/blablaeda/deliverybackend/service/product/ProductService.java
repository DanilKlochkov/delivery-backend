package com.blablaeda.deliverybackend.service.product;

import com.blablaeda.deliverybackend.dto.ProductCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.product.Product;

public interface ProductService {
    Product create(ProductCreateDto productCreateDto);
    void delete(Long id);
    Product findById(Long id);
}
