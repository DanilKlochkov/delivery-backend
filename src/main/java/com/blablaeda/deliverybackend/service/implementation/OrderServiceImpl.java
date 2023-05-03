package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.OrderCreateDto;
import com.blablaeda.deliverybackend.dto.OrderUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.delivery.Order;
import com.blablaeda.deliverybackend.postgres.repository.delivery.OrderRepository;
import com.blablaeda.deliverybackend.service.catalog.AddressService;
import com.blablaeda.deliverybackend.service.delivery.OrderService;
import com.blablaeda.deliverybackend.service.organization.ShopService;
import com.blablaeda.deliverybackend.service.product.ProductService;
import com.blablaeda.deliverybackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final AddressService addressService;
    private final UserService userService;
    private final ShopService shopService;
    @Override
    public Order create(OrderCreateDto orderCreateDto) {
        var order = orderRepository.save(
                Order.builder()
                        .address(addressService.create(orderCreateDto.getAddressCreateDto()))
                        .buyer(userService.findById(orderCreateDto.getBuyerId()))
                        .orderDateTime(LocalDateTime.now())
                        .build()
        );
        orderCreateDto.getProducts().forEach(x ->
            order.addProduct(
                    shopService.findProduct(orderCreateDto.getShopId(), x.getProductId()),
                    x.getCount()
            )
        );
        return orderRepository.save(order);
    }

    @Override
    public Order update(OrderUpdateDto orderCreateDto, Long id) {
        var order = findById(id);

        if (Objects.nonNull(orderCreateDto.getOrderAssemblyDateTime())) {
            order.setOrderAssemblyDateTime(orderCreateDto.getOrderAssemblyDateTime());
        }
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void delete(Long id) {
        orderRepository.delete(findById(id));
    }
}
