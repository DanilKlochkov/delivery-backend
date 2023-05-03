package com.blablaeda.deliverybackend.service.implementation;

import com.blablaeda.deliverybackend.dto.UserDetailsCreateDto;
import com.blablaeda.deliverybackend.dto.UserDetailsUpdateDto;
import com.blablaeda.deliverybackend.postgres.entity.user.UserDetails;
import com.blablaeda.deliverybackend.postgres.repository.organization.OrganizationRepository;
import com.blablaeda.deliverybackend.postgres.repository.users.UserDetailsRepository;
import com.blablaeda.deliverybackend.postgres.repository.users.UserRepository;
import com.blablaeda.deliverybackend.service.user.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails create(UserDetailsCreateDto userDetailsCreateDto) {
        var user = userRepository.findById(userDetailsCreateDto.getUserId()).orElseThrow(NoSuchElementException::new);
        var organization = organizationRepository.findById(userDetailsCreateDto.getOrganizationId()).orElseThrow(NoSuchElementException::new);
        return userDetailsRepository.save(
                UserDetails.builder()
                        .user(user)
                        .organization(organization)
                        .build()
        );
    }

    @Override
    public UserDetails update(UserDetailsUpdateDto userDetailsUpdateDto, Long userId) {
        var updateDetails = userDetailsRepository.findByUser_Id(userId).orElseThrow(NoSuchElementException::new);

        if (Objects.nonNull(userDetailsUpdateDto.getOrganizationId())) {
            updateDetails.setOrganization(organizationRepository.findById(userDetailsUpdateDto.getOrganizationId()).orElseThrow(NoSuchElementException::new));
        }

        return updateDetails;
    }
}
