package com.kafka.user.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.user.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class UserApiTest {

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected UserService userService;

    public final ObjectMapper objectMapper = new ObjectMapper();
}
