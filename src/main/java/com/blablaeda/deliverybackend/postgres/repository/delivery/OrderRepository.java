package com.blablaeda.deliverybackend.postgres.repository.delivery;

import com.blablaeda.deliverybackend.postgres.entity.delivery.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
