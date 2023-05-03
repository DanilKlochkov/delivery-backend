package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.UserSessionCreateDto;
import com.blablaeda.deliverybackend.dto.UserSessionUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.UserSession;
import com.blablaeda.deliverybackend.postgres.repository.users.UserRepository;
import com.blablaeda.deliverybackend.postgres.repository.users.UserSessionRepository;
import com.blablaeda.deliverybackend.service.user.UserSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserSessionServiceImpl implements UserSessionService {
    private final UserRepository userRepository;
    private final UserSessionRepository userSessionRepository;

    @Override
    public UserSession create(UserSessionCreateDto userSessionCreateDto) {
        var user = userRepository.findById(userSessionCreateDto.getUserId()).orElseThrow(NoSuchElementException::new);
        return userSessionRepository.save(
                UserSession.builder()
                        .user(user)
                        .ipAddress(userSessionCreateDto.getIpAddress())
                        .createDate(LocalDateTime.now())
                        .lastActivity(LocalDateTime.now())
                        .isActive(true)
                        .expirationTermDate(userSessionCreateDto.getExpirationTermDate())
                        .build()
        );
    }

    @Override
    public UserSession update(UserSessionUpdateDto userSessionUpdateDto, Long id) {
        var updateSession = userSessionRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if (Objects.nonNull(userSessionUpdateDto.getIsDeleted())) {
            updateSession.setIsActive(userSessionUpdateDto.getIsDeleted());
        }
        if (Objects.nonNull(userSessionUpdateDto.getIpAddress())) {
            updateSession.setIpAddress(userSessionUpdateDto.getIpAddress());
        }
        if (Objects.nonNull(userSessionUpdateDto.getExpirationTermDate())) {
            updateSession.setExpirationTermDate(userSessionUpdateDto.getExpirationTermDate());
        }

        return updateSession;
    }
}
