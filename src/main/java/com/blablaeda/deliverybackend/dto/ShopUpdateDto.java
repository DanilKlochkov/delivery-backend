package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShopUpdateDto {
    private Long administratorId;
    private Long organizationId;
    private String name;
    private AddressCreateDto addressCreateDto;
    private LocalTime openTime;
    private LocalTime closeTime;
}
