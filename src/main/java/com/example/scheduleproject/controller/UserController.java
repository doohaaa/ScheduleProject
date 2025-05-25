package com.example.scheduleproject.controller;


import com.example.scheduleproject.dto.UserResponseDto;
import com.example.scheduleproject.dto.UserSignUpRequestDto;
import com.example.scheduleproject.dto.UserSignUpResponseDto;
import com.example.scheduleproject.entity.User;
import com.example.scheduleproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> userResponseDtoList = userService.findAll();

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }
}
