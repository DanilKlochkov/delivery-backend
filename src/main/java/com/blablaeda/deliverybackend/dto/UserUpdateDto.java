package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String fio = null;
    private String phoneNumber = null;
    private String email = null;
}
