package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryUpdateDto {
    private Long deliveryStatusId;
    private LocalDateTime pickedUpDateTime;
    private LocalDateTime deliveryDateTime;
}
