package com.hellschedule.www.common.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public class ResponseDto<T> {
    private final Integer code;
    private final String message;
    private final T data;

    public ResponseDto(T data) {
        this.code = HttpStatus.OK.value();
        this.message = HttpStatus.OK.name();
        this.data = data;
    }

    public ResponseDto(HttpStatus httpStatus, String msg, T data) {
        this.code = httpStatus.value();
        this.message = msg;
        this.data = data;
    }
}
