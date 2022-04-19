package com.kafka.user.ui.dto;

import com.kafka.user.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
public class ResponseDto<T> {
    private String code;

    private String message;

    private T data;

    private LocalDateTime time;

    private static <T> ResponseDto<T> create(ResponseCode responseCode) {
        return ResponseDto.<T>builder()
                .code(responseCode.getCode())
                .message(responseCode.getMessage())
                .time(LocalDateTime.now())
                .build();
    }

    public static <T> ResponseEntity<ResponseDto<T>> create(ResponseCode responseCode, T data) {
        ResponseDto<T> responseDto = create(responseCode);
        responseDto.setData(data);
        return ResponseEntity.status(responseCode.getStatus())
                .body(responseDto);
    }
}
