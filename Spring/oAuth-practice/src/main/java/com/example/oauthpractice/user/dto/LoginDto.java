package com.example.oauthpractice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class LoginDto {
    private String email;
    private String password;
}
