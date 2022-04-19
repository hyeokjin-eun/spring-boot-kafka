package com.kafka.user.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS("0200", "SUCCESS", 200),
    CREATE("0201", "USER CREATE", 201)
    ;

    private String code;

    private String message;

    private int status;
}
