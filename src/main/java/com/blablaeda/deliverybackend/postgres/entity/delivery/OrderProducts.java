package com.blablaeda.deliverybackend.postgres.entity.delivery;

import com.blablaeda.deliverybackend.postgres.entity.product.ShopProducts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderProducts {
    @Id
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    @ManyToOne(fetch = FetchType.LAZY)
    private ShopProducts product;
    private Integer count;

    public OrderProducts(Order order, ShopProducts product, Integer count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }
}
