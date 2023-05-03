package com.blablaeda.deliverybackend.postgres.entity.delivery;

import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import com.blablaeda.deliverybackend.postgres.entity.product.ShopProducts;
import com.blablaeda.deliverybackend.postgres.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private Long id;
    @OneToOne
    private Address address;
    @OneToOne
    private User buyer;
    private Float cost;
    private LocalDateTime orderDateTime;
    private LocalDateTime orderAssemblyDateTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProducts> products = new HashSet<>();

    public void addProduct(ShopProducts product, Integer count) {
        var orderProduct = new OrderProducts(this, product, count);
        products.add(orderProduct);
    }
}
