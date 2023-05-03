package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class DeliveryCreateDto {
    private Long courierId;
    private Long deliveryStatusId;
    private Long orderId;
}
