package com.kafka.user.error;

import com.kafka.user.enums.ResponseCode;
import com.kafka.user.ui.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<String>> handleRuntimeException(MethodArgumentNotValidException e) {
        return ResponseDto.fail(ResponseCode.BAD_REQUEST);
    }
}
