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
@DisplayName("회원 API")
public class UserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    public final ObjectMapper objectMapper = new ObjectMapper();

    @Nested
    @DisplayName("생성")
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    public class CreateTest {

        private final String URL = "/user";
        private final String ID = "test";
        private final String PASSWORD = "password";
        private final String NAME = "tester";

        @Test
        @DisplayName("성공")
        @Order(0)
        public void create_success() throws Exception {
            UserCreateRequestDto userCreateRequestDto = UserCreateRequestDto.builder()
                    .id(ID)
                    .password(PASSWORD)
                    .name(NAME)
                    .build();

            UserCreateResponseDto userCreateResponseDto = UserCreateResponseDto.builder()
                    .id(ID)
                    .name(NAME)
                    .build();

            given(userService.create(any(UserCreateRequestDto.class))).willReturn(userCreateResponseDto);

            mockMvc.perform(post(URL)
                            .contentType(MediaType.APPLICATION_JSON_VALUE)
                            .content(objectMapper.writeValueAsString(userCreateRequestDto)))
                    .andDo(print())
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.data.id").value(ID))
                    .andExpect(jsonPath("$.data.name").value(NAME))
                    ;

            verify(userService).create(any(UserCreateRequestDto.class));
        }
    }
}
