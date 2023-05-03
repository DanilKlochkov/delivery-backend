package com.blablaeda.deliverybackend.postgres.entity.organization;

import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import com.blablaeda.deliverybackend.postgres.entity.product.Product;
import com.blablaeda.deliverybackend.postgres.entity.product.ShopProducts;
import com.blablaeda.deliverybackend.postgres.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Entity
@Table(schema = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shop {
    @Id
    private Long id;
    @OneToOne
    private User administrator;
    @OneToOne
    private Organization organization;
    private String name;
    @OneToOne
    private Address address;
    private LocalTime openTime;
    private LocalTime closeTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shop_staff",
            joinColumns = {@JoinColumn(name = "shop_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private List<User> staff;

    public void addEmployee(User employee) {
        this.staff.add(employee);
    }

    public void removeEmployee(User employee) {
        this.staff.remove(employee);
    }

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private Set<ShopProducts> products = new HashSet<>();

    public void addProduct(Product product, Long count) {
        var shopProduct = new ShopProducts(this, product, count);
        products.add(shopProduct);
    }

    public void setProductCount(Product product, Long count) {
        var shopProduct = this.getProducts().stream().filter(x -> x.getProduct().equals(product)).findFirst().orElseThrow(NoSuchElementException::new);
        shopProduct.setCount(count);
    }

    public void removeProduct(Product product) {
        var shopProduct = this.getProducts().stream().filter(x -> x.getProduct().equals(product)).findFirst().orElseThrow(NoSuchElementException::new);
        this.products.remove(shopProduct);
    }
}
