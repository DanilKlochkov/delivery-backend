package com.blablaeda.deliverybackend.postgres.repository.users;

import com.blablaeda.deliverybackend.postgres.entity.user.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByUser_Id(Long userId);
}
