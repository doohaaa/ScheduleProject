package com.example.scheduleproject.domain.user;


import com.example.scheduleproject.domain.user.dto.UpdateUserEmailRequestDto;
import com.example.scheduleproject.domain.user.dto.UserResponseDto;
import com.example.scheduleproject.domain.user.dto.UserSignUpRequestDto;
import com.example.scheduleproject.domain.user.dto.UserSignUpResponseDto;
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

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateUserEmail(@PathVariable Long id, @RequestBody UpdateUserEmailRequestDto requestDto){
        userService.updateUserEmail(id, requestDto.getNewEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
