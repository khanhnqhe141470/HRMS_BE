package com.swp490_g2.hrms.service;

import com.swp490_g2.hrms.entity.User;
import com.swp490_g2.hrms.requests.AddUserRequest;
import com.swp490_g2.hrms.security.WebSecurityConfig;
import com.swp490_g2.hrms.service.UserService;
import com.swp490_g2.hrms.validation.EmailExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.swp490_g2.hrms.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private WebSecurityConfig webSecurityConfig;

    @Override
    public User registerNewUserAccount(AddUserRequest user){
        return userRepository.save(
                User.builder()
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .middleName(user.getMiddleName())
                .lastName(user.getLastName())
                .password(webSecurityConfig.passwordEncoder().encode(user.getPassword()))
                .phoneNumber(user.getPhoneNumber())
                .isActive(user.getIsActive())
                .build());
    }


}
