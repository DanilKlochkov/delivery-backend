package com.blablaeda.deliverybackend.postgres.entity.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryStatus {
    @Id
    private Long id;
    private String name;

    private static final Long ORDER_ACCEPTED = 1L;
    private static final Long ORDER_ASSEMBLED = 2L;
    private static final Long ORDER_PICKED_UP = 3L;
    private static final Long COURIER_ON_THE_WAY = 4L;
    private static final Long COURIER_ON_THE_SPOT = 5L;
    private static final Long COMPLETED = 6L;
    private static final Long CANCELLED = 7L;
}
