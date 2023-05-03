package com.blablaeda.deliverybackend.service.user;

import com.blablaeda.deliverybackend.dto.UserSessionCreateDto;
import com.blablaeda.deliverybackend.dto.UserSessionUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.UserSession;

public interface UserSessionService {
    UserSession create(UserSessionCreateDto userSessionCreateDto);
    UserSession update(UserSessionUpdateDto userSessionUpdateDto, Long id);
}
