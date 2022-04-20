package com.kafka.user.ui;

import com.kafka.user.enums.ResponseCode;
import com.kafka.user.ui.dto.request.UserCreateRequestDto;
import com.kafka.user.ui.dto.response.UserCreateResponseDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.http.MediaType;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
@DisplayName("회원 생성 API")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserApiCreateTest extends UserApiTest{

    private final String URL = "/user";
    private final String ID = "test";
    private final String PASSWORD = "password";
    private final String NAME = "tester";

    private UserCreateRequestDto userCreateRequestDto;
    private UserCreateResponseDto userCreateResponseDto;

    @BeforeEach
    public void beforeEach() {
        userCreateRequestDto = UserCreateRequestDto.builder()
                .id(ID)
                .password(PASSWORD)
                .name(NAME)
                .build();

        userCreateResponseDto = UserCreateResponseDto.builder()
                .id(ID)
                .name(NAME)
                .build();
    }

    @Test
    @DisplayName("성공")
    @Order(0)
    public void create_success() throws Exception {
        given(userService.create(any(UserCreateRequestDto.class))).willReturn(userCreateResponseDto);

        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userCreateRequestDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value(ResponseCode.CREATE.getCode()))
                .andExpect(jsonPath("$.data.id").value(ID))
                .andExpect(jsonPath("$.data.name").value(NAME))
        ;

        verify(userService).create(any(UserCreateRequestDto.class));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("회원 ID 누락")
    @Order(1)
    public void create_id_null_and_empty(String id) throws Exception {
        userCreateRequestDto.setId(id);
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(userCreateRequestDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(ResponseCode.BAD_REQUEST.getCode()))
        ;
    }
}
