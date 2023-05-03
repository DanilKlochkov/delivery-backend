package com.blablaeda.deliverybackend.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserCreateDto {
    private String fio;
    private String password;
    private String phoneNumber;
    private String email;
    private Set<Long> rolesId;
}
