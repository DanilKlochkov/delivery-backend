package com.blablaeda.deliverybackend.service.user;

import com.blablaeda.deliverybackend.dto.UserDetailsCreateDto;
import com.blablaeda.deliverybackend.dto.UserDetailsUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.UserDetails;

public interface UserDetailsService {
    UserDetails create(UserDetailsCreateDto userDetailsCreateDto);
    UserDetails update(UserDetailsUpdateDto userDetailsUpdateDto, Long userId);
}
