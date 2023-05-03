package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class OrganizationUpdateDto {
    private String name;
    private String ownerFio;
    private AddressCreateDto addressCreateDto;
    private String inn;
    private String ogrn;
    private String kpp;
    private String phoneNumber;
    private String website;
}
