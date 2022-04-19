package com.kafka.user.application;

import com.kafka.user.ui.dto.request.UserCreateRequestDto;
import com.kafka.user.ui.dto.response.UserCreateResponseDto;

public interface UserService {

    UserCreateResponseDto create(UserCreateRequestDto userCreateRequestDto);
}
