package com.hellschedule.www.common.exception;

// 추후에 사용할 예정
public class CustomForbiddenException extends RuntimeException {
    public CustomForbiddenException(String message) {
        super(message);
    }
}
