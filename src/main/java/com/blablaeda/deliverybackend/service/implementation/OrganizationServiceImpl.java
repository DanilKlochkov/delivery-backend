package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.OrganizationCreateDto;
import com.blablaeda.deliverybackend.dto.OrganizationUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.organization.Organization;
import com.blablaeda.deliverybackend.postgres.repository.organization.OrganizationRepository;
import com.blablaeda.deliverybackend.service.catalog.AddressService;
import com.blablaeda.deliverybackend.service.organization.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final AddressService addressService;

    @Override
    public Organization create(OrganizationCreateDto organizationCreateDto) {
        return organizationRepository.save(
                Organization.builder()
                        .name(organizationCreateDto.getName())
                        .officeAddress(addressService.create(organizationCreateDto.getAddressCreateDto()))
                        .kpp(organizationCreateDto.getKpp())
                        .inn(organizationCreateDto.getInn())
                        .ogrn(organizationCreateDto.getOgrn())
                        .phoneNumber(organizationCreateDto.getPhoneNumber())
                        .ownerFio(organizationCreateDto.getOwnerFio())
                        .website(organizationCreateDto.getWebsite())
                        .build()
        );
    }

    @Override
    public Organization update(OrganizationUpdateDto organizationCreateDto, Long id) {
        var updateOrganization = organizationRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return null;
    }

    @Override
    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
