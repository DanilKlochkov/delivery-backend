package com.blablaeda.deliverybackend.postgres.repository.catalog;

import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
