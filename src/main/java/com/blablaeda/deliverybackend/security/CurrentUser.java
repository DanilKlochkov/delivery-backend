package com.blablaeda.deliverybackend.security;

import com.blablaeda.deliverybackend.postgres.entity.user.User;
import com.blablaeda.deliverybackend.postgres.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class CurrentUser {
    private final UserRepository userRepository;
    public User getUser() {
            return userRepository.findById(((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()).orElseThrow(NoSuchElementException::new);
    }
}
