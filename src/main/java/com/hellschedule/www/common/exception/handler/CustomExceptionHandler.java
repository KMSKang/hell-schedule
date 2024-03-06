package com.hellschedule.www.common.exception.handler;

import com.hellschedule.www.common.dto.ResponseDto;
import com.hellschedule.www.common.exception.CustomApiException;
import com.hellschedule.www.common.exception.CustomForbiddenException;
import com.hellschedule.www.common.exception.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    // 400
    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<?> customValidationException(CustomValidationException e) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(new ResponseDto<>(httpStatus.value(), e.getMessage(), e.getErroMap()), httpStatus);
    }

    // 403
    @ExceptionHandler(CustomForbiddenException.class)
    public ResponseEntity<?> customForbiddenException(CustomForbiddenException e) {
        HttpStatus httpStatus = HttpStatus.FORBIDDEN;
        return new ResponseEntity<>(new ResponseDto<>(httpStatus.value(), e.getMessage(), null), httpStatus);
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> customApiException(CustomApiException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ResponseDto<>(httpStatus.value(), e.getMessage(), null), httpStatus);
    }

    // 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(CustomApiException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ResponseDto<>(httpStatus.value(), e.getMessage(), null), httpStatus);
    }
}
