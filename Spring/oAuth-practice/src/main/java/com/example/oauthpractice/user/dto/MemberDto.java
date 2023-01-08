package com.example.oauthpractice.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDto {
    private String email;
    private String nickname;
    private String password;
    private boolean admin;
    private String adminToken;

    @Override
    public String toString() {
        return "MemberDto{" +
                "email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", adminToken='" + adminToken + '\'' +
                '}';
    }
}