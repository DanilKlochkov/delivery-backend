package com.blablaeda.deliverybackend.service.delivery;

import com.blablaeda.deliverybackend.dto.DeliveryCreateDto;
import com.blablaeda.deliverybackend.dto.DeliveryUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.delivery.Delivery;

public interface DeliveryService {
    Delivery create(DeliveryCreateDto deliveryCreateDto);
    Delivery update(DeliveryUpdateDto deliveryUpdateDto, Long id);
}
