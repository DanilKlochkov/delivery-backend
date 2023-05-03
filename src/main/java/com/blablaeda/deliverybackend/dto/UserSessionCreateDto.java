package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserSessionCreateDto {
    private Long userId;
    private String ipAddress;
    private LocalDateTime expirationTermDate;
}
