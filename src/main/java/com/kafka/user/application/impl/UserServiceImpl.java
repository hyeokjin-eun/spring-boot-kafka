package com.kafka.user.application.impl;

import com.kafka.user.application.UserService;
import com.kafka.user.ui.dto.request.UserCreateRequestDto;
import com.kafka.user.ui.dto.response.UserCreateResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserCreateResponseDto create(UserCreateRequestDto userCreateRequestDto) {
        return null;
    }
}
