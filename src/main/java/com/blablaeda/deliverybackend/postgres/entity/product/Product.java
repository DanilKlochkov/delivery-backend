package com.blablaeda.deliverybackend.postgres.entity.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Product {
    @Id
    private Long id;
    private String name;
    private Float price;
    private Float proteins;
    private Float fats;
    private Float carbohydrates;
    private String description;
    private Float weight;
    private String producer;
}
