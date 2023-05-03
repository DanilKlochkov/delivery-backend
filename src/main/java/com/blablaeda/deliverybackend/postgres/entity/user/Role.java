package com.blablaeda.deliverybackend.postgres.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Role {
    @Id
    private Long id;
    private String name;

    public static final Long ADMIN_IS = 1L;
    public static final Long CLIENT = 2L;
    public static final Long COURIER = 3L;
    public static final Long SHOP_ADMIN = 4L;
    public static final Long SHOP_EMPLOYEE = 5L;
}
