package com.auth.service;

import com.auth.controller.dto.UserDto;
import com.auth.entity.AuthUser;
import com.auth.repository.UserRepository;
import com.auth.repository.UserRoleRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AuthUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUser register(UserDto userDto) {
        AuthUser authUser = new ObjectMapper().convertValue(userDto, AuthUser.class);
        authUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        authUser.setRoles(Collections.singletonList(userRoleRepo.findByRoleNameContaining("USER")));
        Optional<AuthUser> optUser = userRepository.findByUserNameOrEmail(userDto.getUserName(), userDto.getEmail());
        if (!optUser.isPresent()) {
            return userRepository.save(authUser);
        }
        throw new RuntimeException("User already exist");
    }
}
