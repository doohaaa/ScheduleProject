package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter
public class UserSignUpRequestDto {

    private final String username;
    private final String email;

    public UserSignUpRequestDto(String username, String email){
        this.username = username;
        this.email = email;
    }

}
