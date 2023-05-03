package com.blablaeda.deliverybackend.postgres.entity.delivery;

import com.blablaeda.deliverybackend.postgres.entity.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(schema = "delivery")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Delivery {
    @Id
    private Long id;
    @OneToOne
    private User courier;
    @OneToOne
    private DeliveryStatus status;
    @OneToOne
    private Order order;
    private LocalDateTime pickedUpDateTime;
    private LocalDateTime deliveryDateTime;
}
