package com.blablaeda.deliverybackend.postgres.repository.users;

import com.blablaeda.deliverybackend.postgres.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailOrPhoneNumber(String email, String phoneNumber);
    boolean existsByPhoneNumber(String phone);
}
