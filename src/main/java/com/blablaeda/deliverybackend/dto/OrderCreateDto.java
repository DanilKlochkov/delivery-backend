package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderCreateDto {
    private AddressCreateDto addressCreateDto;
    private Long buyerId;
    private Float cost;
    private LocalDateTime orderDateTime;
    private LocalDateTime orderAssemblyDateTime;
    private Long shopId;
    private List<ProductDto> products;

    @Data
    public static class ProductDto {
        private Long productId;
        private Integer count;
    }
}
