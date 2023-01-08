package com.example.oauthpractice.advice;

import com.example.oauthpractice.exception.BusinessLogicException;
import com.example.oauthpractice.user.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = {BusinessLogicException.class})
    public ResponseEntity<Object> handleAdminErrorException(BusinessLogicException exception) {
        log.error("throw customException : {}", exception.getExceptionCode());
        ResponseDto restApiException = new ResponseDto(exception.getExceptionCode().getStatus(),
                exception.getExceptionCode().getMessage(), "");
        return new ResponseEntity<>(restApiException, HttpStatus.valueOf(exception.getExceptionCode().getStatus()));
    }
}