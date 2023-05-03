package com.blablaeda.deliverybackend.postgres.entity.organization;

import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "organization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {
    @Id
    private Long id;
    private String name;
    private String ownerFio;
    @OneToOne
    private Address officeAddress;
    private String inn;
    private String ogrn;
    private String kpp;
    private String phoneNumber;
    private String website;
}
