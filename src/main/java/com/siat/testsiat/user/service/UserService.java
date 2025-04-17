package com.siat.testsiat.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siat.testsiat.user.dao.UserMapper;
import com.siat.testsiat.user.model.domain.UserRequestDTO;
import com.siat.testsiat.user.model.domain.UserResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    public UserResponseDTO loginService(UserRequestDTO params) {
        log.info("debug User service /login: " + params);
        return mapper.loginRow(params);
    }
}
