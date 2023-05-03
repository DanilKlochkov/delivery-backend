package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.LoginDto;
import com.blablaeda.deliverybackend.dto.UserCreateDto;
import com.blablaeda.deliverybackend.dto.UserUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.Role;
import com.blablaeda.deliverybackend.postgres.entity.user.User;
import com.blablaeda.deliverybackend.postgres.repository.users.RoleRepository;
import com.blablaeda.deliverybackend.postgres.repository.users.UserRepository;
import com.blablaeda.deliverybackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User login(LoginDto loginDto) {
        if (!userRepository.existsByPhoneNumber(loginDto.phone())) {
            var user = User.builder()
                    .phoneNumber(loginDto.phone())
                    .password(passwordEncoder.encode(loginDto.code()))
                    .roles(List.of(
                            roleRepository.findById(Role.CLIENT).orElseThrow()
                    ))
                    .build();
            return userRepository.save(user);
        } else {
            return userRepository.findByEmailOrPhoneNumber(loginDto.phone(), loginDto.phone()).get();
        }
    }

    @Override
    public User create(UserCreateDto userDto) {
        var roles = new HashSet<>(roleRepository.findAllById(userDto.getRolesId()));
        return userRepository.save(
                User.builder()
                        .fio(userDto.getFio())
                        .phoneNumber(userDto.getPhoneNumber())
                        .email(userDto.getEmail())
                        .password(passwordEncoder.encode(userDto.getPassword()))
                        .createDate(LocalDateTime.now())
                        .isDeleted(false)
                        .roles(roles)
                        .build()
        );
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User update(UserUpdateDto userDto, Long id) {
        var updateUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if (Objects.nonNull(userDto.getFio())) {
            updateUser.setFio(userDto.getFio());
        }
        if (Objects.nonNull(userDto.getEmail())) {
            updateUser.setEmail(userDto.getEmail());
        }
        if (Objects.nonNull(userDto.getPhoneNumber())) {
            updateUser.setPhoneNumber(userDto.getPhoneNumber());
        }
        return updateUser;
    }

    @Override
    public Optional<User> findByEmailOrPhone(String emailOrPhone) {
        return userRepository.findByEmailOrPhoneNumber(emailOrPhone, emailOrPhone);
    }

    @Override
    public User addRole(Long roleId, Long id) {
        var updateUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var role = roleRepository.findById(id).orElseThrow(NoSuchElementException::new);
        updateUser.addRole(role);
        return userRepository.save(updateUser);
    }

    @Override
    public User deleteRole(Long roleId, Long id) {
        var updateUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        var role = roleRepository.findById(id).orElseThrow(NoSuchElementException::new);
        updateUser.removeRole(role);
        return userRepository.save(updateUser);
    }

    @Override
    public void delete(Long id) {
        var updateUser = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        updateUser.setIsDeleted(true);
        userRepository.save(updateUser);
    }
}
