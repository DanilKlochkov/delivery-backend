package com.blablaeda.deliverybackend.postgres.repository.users;

import com.blablaeda.deliverybackend.postgres.entity.user.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
}
