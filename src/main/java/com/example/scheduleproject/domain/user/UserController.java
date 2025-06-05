package com.example.scheduleproject.domain.user;


import com.example.scheduleproject.domain.user.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
                        requestDto.getEmail(),
                        requestDto.getPassword()
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

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest servletRequest){
        final LoginResponseDto loginResponseDto = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        // ? 이건 왜하는거
        final HttpSession session = servletRequest.getSession();
        session.setAttribute("user", loginResponseDto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest servletRequest){
        HttpSession session = servletRequest.getSession(false);

        if(session != null){
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
