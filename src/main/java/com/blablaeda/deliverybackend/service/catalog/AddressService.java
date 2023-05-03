package com.blablaeda.deliverybackend.service.catalog;

import com.blablaeda.deliverybackend.dto.AddressCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;

public interface AddressService {
    Address create(AddressCreateDto addressCreateDto);
}
