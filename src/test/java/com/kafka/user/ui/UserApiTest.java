package com.kafka.user.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.user.application.UserService;
import com.kafka.user.ui.dto.request.UserCreateRequestDto;
import com.kafka.user.ui.dto.response.UserCreateResponseDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class UserApiTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected UserService userService;

    public final ObjectMapper objectMapper = new ObjectMapper();
}
