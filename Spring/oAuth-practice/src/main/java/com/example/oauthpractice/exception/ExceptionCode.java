package com.example.oauthpractice.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member not found"),
    MEMBER_EXISTS(409, "Member exists"),
    ADMIN_TOKEN(400, "Incorrect Admin Password"),
    NO_LOGIN(401, "로그인이 필요합니다"),
    NO_ADMIN(403, "권한이 없는 사용자입니다");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }

}
