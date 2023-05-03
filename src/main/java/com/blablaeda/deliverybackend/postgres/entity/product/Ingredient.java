package com.blablaeda.deliverybackend.postgres.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(schema = "product", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {
    @Id
    private Long id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="products_ingredients",
            joinColumns = {@JoinColumn(name="ingredient_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="product_id", referencedColumnName="id")}
    )
    private List<Product> products;
}
