package com.dh.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UserLoginDto {
    private final String username;
    private final String password;

    @JsonCreator
    UserLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
