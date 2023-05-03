package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class UserDetailsCreateDto {
    private Long organizationId;
    private Long userId;
}
