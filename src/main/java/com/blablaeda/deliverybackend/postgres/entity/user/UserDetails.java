package com.blablaeda.deliverybackend.postgres.entity.user;

import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import com.blablaeda.deliverybackend.postgres.entity.organization.Organization;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    @Id
    private Long id;
    @OneToOne
    private User user;
    @OneToOne
    private Address address;
    @OneToOne
    private Organization organization;
    private Float rating;
}
