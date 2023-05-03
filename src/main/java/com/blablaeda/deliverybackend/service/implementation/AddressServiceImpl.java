package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.AddressCreateDto;
import com.blablaeda.deliverybackend.postgres.entity.catalog.Address;
import com.blablaeda.deliverybackend.postgres.repository.catalog.AddressRepository;
import com.blablaeda.deliverybackend.service.catalog.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Override
    public Address create(AddressCreateDto addressCreateDto) {
        return addressRepository.save(
                Address.builder()
                        .city(addressCreateDto.getCity())
                        .rayon(addressCreateDto.getRayon())
                        .street(addressCreateDto.getStreet())
                        .houseNumber(addressCreateDto.getHouseNumber())
                        .apartmentNumber(addressCreateDto.getApartmentNumber())
                        .areaIndex(addressCreateDto.getAreaIndex())
                        .fullAddress(addressCreateDto.getFullAddress())
                        .build()
        );
    }
}
