package com.blablaeda.deliverybackend.postgres.repository.delivery;

import com.blablaeda.deliverybackend.postgres.entity.delivery.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus, Long> {
}
