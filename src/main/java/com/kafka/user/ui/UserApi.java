package com.kafka.user.ui;

import com.kafka.user.application.UserService;
import com.kafka.user.enums.ResponseCode;
import com.kafka.user.ui.dto.ResponseDto;
import com.kafka.user.ui.dto.request.UserCreateRequestDto;
import com.kafka.user.ui.dto.response.UserCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<ResponseDto<UserCreateResponseDto>> create(
            @Valid @RequestBody UserCreateRequestDto userCreateRequestDto) {
        return ResponseDto.create(ResponseCode.CREATE, userService.create(userCreateRequestDto));
    }
}
