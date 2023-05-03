package com.blablaeda.deliverybackend.service.delivery;

import com.blablaeda.deliverybackend.dto.OrderCreateDto;
import com.blablaeda.deliverybackend.dto.OrderUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.delivery.Order;

public interface OrderService {
    Order create(OrderCreateDto orderCreateDto);
    Order update(OrderUpdateDto orderCreateDto, Long id);
    Order findById(Long id);
    void delete(Long id);
}
