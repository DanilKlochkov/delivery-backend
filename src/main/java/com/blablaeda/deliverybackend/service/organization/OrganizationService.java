package com.blablaeda.deliverybackend.service.organization;

import com.blablaeda.deliverybackend.dto.OrganizationCreateDto;
import com.blablaeda.deliverybackend.dto.OrganizationUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.organization.Organization;

public interface OrganizationService {
    Organization create(OrganizationCreateDto organizationCreateDto);
    Organization update(OrganizationUpdateDto organizationCreateDto, Long id);
    Organization findById(Long id);
}
