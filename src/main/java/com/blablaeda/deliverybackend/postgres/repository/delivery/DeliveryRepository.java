package com.blablaeda.deliverybackend.postgres.repository.delivery;

import com.blablaeda.deliverybackend.postgres.entity.delivery.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
