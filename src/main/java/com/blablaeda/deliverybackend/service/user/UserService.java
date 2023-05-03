package com.blablaeda.deliverybackend.service.user;

import com.blablaeda.deliverybackend.dto.LoginDto;
import com.blablaeda.deliverybackend.dto.UserCreateDto;
import com.blablaeda.deliverybackend.dto.UserUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.User;

import java.util.Optional;

public interface UserService {
    User login(LoginDto loginDto);
    User create(UserCreateDto userDto);
    User findById(Long id);
    User update(UserUpdateDto userDto, Long id);
    Optional<User> findByEmailOrPhone(String emailOrPhone);
    User addRole(Long roleId, Long id);
    User deleteRole(Long roleId, Long id);
    void delete(Long id);
}
