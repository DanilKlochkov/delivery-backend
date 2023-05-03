package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserSessionUpdateDto {
    private String ipAddress = null;
    private Boolean isDeleted = null;
    private LocalDateTime expirationTermDate = null;
}
