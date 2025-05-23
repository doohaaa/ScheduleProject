package com.example.scheduleproject.controller;


import com.example.scheduleproject.dto.UserSignUpRequestDto;
import com.example.scheduleproject.dto.UserSignUpResponseDto;
import com.example.scheduleproject.entity.User;
import com.example.scheduleproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpResponseDto> signUp(@RequestBody UserSignUpRequestDto requestDto){
        UserSignUpResponseDto userSignUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getEmail()
                );
        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.CREATED);
    }
}
