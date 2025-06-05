package com.example.scheduleproject.domain.user.dto;

import com.example.scheduleproject.domain.user.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class LoginResponseDto implements Serializable {
    private Long id;
    private String name;
    private String email;

    // 기능
    public static LoginResponseDto of(User user){
        final LoginResponseDto response = new LoginResponseDto();

        response.id = user.getId();
        response.name = user.getUsername();
        response.email = user.getEmail();

        return response;
    }
}
