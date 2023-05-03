package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class ProductCreateDto {
    private String name;
    private Float price;
    private Float proteins;
    private Float fats;
    private Float carbohydrates;
    private String description;
    private Float weight;
    private String producer;
}
