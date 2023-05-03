package com.blablaeda.deliverybackend.postgres.repository.users;

import com.blablaeda.deliverybackend.postgres.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
