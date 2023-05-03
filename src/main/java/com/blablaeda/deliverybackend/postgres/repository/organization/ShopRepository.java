package com.blablaeda.deliverybackend.postgres.repository.organization;

import com.blablaeda.deliverybackend.postgres.entity.organization.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
