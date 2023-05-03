package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.ShopCreateDto;
import com.blablaeda.deliverybackend.dto.ShopUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.organization.Shop;
import com.blablaeda.deliverybackend.postgres.entity.product.ShopProducts;
import com.blablaeda.deliverybackend.postgres.repository.organization.ShopRepository;
import com.blablaeda.deliverybackend.service.catalog.AddressService;
import com.blablaeda.deliverybackend.service.organization.OrganizationService;
import com.blablaeda.deliverybackend.service.organization.ShopService;
import com.blablaeda.deliverybackend.service.product.ProductService;
import com.blablaeda.deliverybackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository shopRepository;
    private final AddressService addressService;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final ProductService productService;

    @Override
    public Shop create(ShopCreateDto shop) {
        return shopRepository.save(Shop.builder()
                .address(addressService.create(shop.getAddressCreateDto()))
                .administrator(userService.findById(shop.getAdministratorId()))
                .organization(organizationService.findById(shop.getOrganizationId()))
                .name(shop.getName())
                .openTime(shop.getOpenTime())
                .closeTime(shop.getCloseTime())
                .build());
    }

    @Override
    public Shop update(ShopUpdateDto shop, Long shopId) {
        return null;
    }

    @Override
    public ShopProducts findProduct(Long shopId, Long productId) {
        return shopRepository.findById(shopId).orElseThrow(NoSuchElementException::new)
                .getProducts()
                .stream()
                .filter(x -> x.getId().equals(productId))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public void addProduct(Long productId, Long count, Long shopId) {
        var shop = shopRepository.findById(shopId).orElseThrow(NoSuchElementException::new);
        var product = productService.findById(productId);
        shop.addProduct(product, count);
        shopRepository.save(shop);
    }

    @Override
    public void setProductCount(Long productId, Long newCount, Long shopId) {
        var shop = shopRepository.findById(shopId).orElseThrow(NoSuchElementException::new);
        var product = productService.findById(productId);
        shop.setProductCount(product, newCount);
        shopRepository.save(shop);
    }

    @Override
    public void removeProduct(Long productId, Long shopId) {
        var shop = shopRepository.findById(shopId).orElseThrow(NoSuchElementException::new);
        var product = productService.findById(productId);
        shop.removeProduct(product);
        shopRepository.save(shop);
    }

    @Override
    public void addEmployee(Long userId, Long shopId) {
        var user = userService.findById(userId);
        var shop = shopRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        shop.addEmployee(user);
        shopRepository.save(shop);
    }

    @Override
    public void removeEmployee(Long userId, Long shopId) {
        var user = userService.findById(userId);
        var shop = shopRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        shop.removeEmployee(user);
        shopRepository.save(shop);
    }
}
