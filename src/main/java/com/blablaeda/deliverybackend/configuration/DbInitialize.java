package com.blablaeda.deliverybackend.configuration;

import com.blablaeda.deliverybackend.postgres.entity.user.Role;
import com.blablaeda.deliverybackend.postgres.entity.user.User;
import com.blablaeda.deliverybackend.postgres.repository.users.RoleRepository;
import com.blablaeda.deliverybackend.postgres.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInitialize implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    @Value("${app.adminPassword}")
    private String adminPassword;

    @Override
    public void run(String... args) {
        if (!roleRepository.findAll().isEmpty()) {
            return;
        }
        roleRepository.saveAll(Arrays.asList(
                Role.builder()
                        .id(Role.ADMIN_IS)
                        .name("ROLE_ADMIN_iS")
                        .build(),
                Role.builder()
                        .id(Role.CLIENT)
                        .name("ROLE_CLIENT")
                        .build(),
                Role.builder()
                        .id(Role.COURIER)
                        .name("ROLE_COURIER")
                        .build(),
                Role.builder()
                        .id(Role.SHOP_ADMIN)
                        .name("ROLE_SHOP_ADMIN")
                        .build(),
                Role.builder()
                        .id(Role.SHOP_EMPLOYEE)
                        .name("ROLE_SHOP_EMPLOYEE")
                        .build()
        ));

        if (!userRepository.findAll().isEmpty()) {
            return;
        }
        userRepository.saveAll(Collections.singletonList(
                User.builder()
                        .fio("Администратор ИС")
                        .phoneNumber("+79090909090")
                        .email("admin@admin.admin")
                        .createDate(LocalDateTime.now())
                        .password(passwordEncoder.encode(adminPassword))
                        .isDeleted(false)
                        .roles(List.of(
                                roleRepository.findById(Role.ADMIN_IS).orElseThrow()
                        ))
                        .build())
        );
    }
}
