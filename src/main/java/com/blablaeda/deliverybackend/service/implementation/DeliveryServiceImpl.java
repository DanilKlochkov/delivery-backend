package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.DeliveryCreateDto;
import com.blablaeda.deliverybackend.dto.DeliveryUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.delivery.Delivery;
import com.blablaeda.deliverybackend.postgres.repository.delivery.DeliveryRepository;
import com.blablaeda.deliverybackend.postgres.repository.delivery.DeliveryStatusRepository;
import com.blablaeda.deliverybackend.service.delivery.DeliveryService;
import com.blablaeda.deliverybackend.service.delivery.OrderService;
import com.blablaeda.deliverybackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final UserService userService;
    private final DeliveryStatusRepository deliveryStatusRepository;
    private final OrderService orderService;


    @Override
    public Delivery create(DeliveryCreateDto deliveryCreateDto) {
        return deliveryRepository.save(
                Delivery.builder()
                        .courier(userService.findById(deliveryCreateDto.getCourierId()))
                        .status(deliveryStatusRepository.findById(deliveryCreateDto.getDeliveryStatusId()).orElseThrow(NoSuchElementException::new))
                        .order(orderService.findById(deliveryCreateDto.getOrderId()))
                        .build()
        );
    }

    @Override
    public Delivery update(DeliveryUpdateDto deliveryUpdateDto, Long id) {
        var delivery = deliveryRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if (Objects.nonNull(deliveryUpdateDto.getDeliveryStatusId())) {
            delivery.setStatus(deliveryStatusRepository.findById(deliveryUpdateDto.getDeliveryStatusId()).orElseThrow(NoSuchElementException::new));
        }
        if (Objects.nonNull(deliveryUpdateDto.getDeliveryDateTime())) {
            delivery.setDeliveryDateTime(deliveryUpdateDto.getDeliveryDateTime());
        }
        if (Objects.nonNull(deliveryUpdateDto.getPickedUpDateTime())) {
            delivery.setPickedUpDateTime(deliveryUpdateDto.getPickedUpDateTime());
        }
        return deliveryRepository.save(delivery);
    }
}
