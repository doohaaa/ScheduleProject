package com.example.scheduleproject.dto;

import lombok.Getter;

@Getter
public class UpdateUserEmailRequestDto {

    private final String newEmail;

    public UpdateUserEmailRequestDto(String newEmail){
        this.newEmail = newEmail;
    }
}
