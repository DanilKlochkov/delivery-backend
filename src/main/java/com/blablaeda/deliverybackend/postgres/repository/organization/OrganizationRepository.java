package com.blablaeda.deliverybackend.postgres.repository.organization;

import com.blablaeda.deliverybackend.postgres.entity.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
