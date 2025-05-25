package com.example.scheduleproject.service;

import com.example.scheduleproject.dto.UserResponseDto;
import com.example.scheduleproject.dto.UserSignUpResponseDto;
import com.example.scheduleproject.entity.User;
import com.example.scheduleproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(String username, String email){

        User user = new User(username, email);

        User savedUser = userRepository.save(user);

        return new UserSignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResponseDto findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);

        // NPE 받지
        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exit id = "+id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(findUser.getUsername(), findUser.getEmail());
    }

    public List<UserResponseDto> findAll(){
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }
}
