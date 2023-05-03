package com.blablaeda.deliverybackend.dto;

import lombok.Data;

@Data
public class AddressCreateDto {
    private String city;
    private String rayon;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String areaIndex;
    private String fullAddress;
}
