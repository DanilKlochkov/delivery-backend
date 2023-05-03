package com.blablaeda.deliverybackend.postgres.entity.catalog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "catalog")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    private Long id;
    private String city;
    private String rayon;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String areaIndex;
    private String fullAddress;
}
