package com.blablaeda.deliverybackend.postgres.entity.product;

import com.blablaeda.deliverybackend.postgres.entity.organization.Shop;
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
public class ShopProducts {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private Shop shop;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    private Product product;
    private Long count;

    public ShopProducts(Shop shop, Product product, Long count) {
        this.shop = shop;
        this.product = product;
        this.count = count;
    }
}
