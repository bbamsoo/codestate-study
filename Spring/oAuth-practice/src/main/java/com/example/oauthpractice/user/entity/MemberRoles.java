package com.example.oauthpractice.user.entity;

import lombok.Getter;

@Getter
public enum MemberRoles {
    ROLE_ADMIN("관리자"), ROLE_MEMBER("일반사용자");

    private String description;

    MemberRoles(String description) {
        this.description = description;
    }
}
