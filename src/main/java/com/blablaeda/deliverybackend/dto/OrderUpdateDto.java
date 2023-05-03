package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderUpdateDto {
    private LocalDateTime orderAssemblyDateTime;
}
