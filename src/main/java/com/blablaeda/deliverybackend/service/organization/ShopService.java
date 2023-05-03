package com.blablaeda.deliverybackend.service.organization;

import com.blablaeda.deliverybackend.dto.ShopCreateDto;
import com.blablaeda.deliverybackend.dto.ShopUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.organization.Shop;
import com.blablaeda.deliverybackend.postgres.entity.product.ShopProducts;

public interface ShopService {
    Shop create(ShopCreateDto shop);
    Shop update(ShopUpdateDto shop, Long shopId);
    ShopProducts findProduct(Long shopId, Long productId);
    void addProduct(Long productId, Long count, Long shopId);
    void setProductCount(Long productId, Long newCount, Long shopId);
    void removeProduct(Long productId, Long shopId);
    void addEmployee(Long userId, Long shopId);
    void removeEmployee(Long userId, Long shopId);
}
