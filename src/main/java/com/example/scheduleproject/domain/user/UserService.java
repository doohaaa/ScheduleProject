package com.example.scheduleproject.domain.user;

import com.example.scheduleproject.domain.user.dto.LoginRequestDto;
import com.example.scheduleproject.domain.user.dto.LoginResponseDto;
import com.example.scheduleproject.domain.user.dto.UserResponseDto;
import com.example.scheduleproject.domain.user.dto.UserSignUpResponseDto;
import com.example.scheduleproject.domain.user.entity.User;
import com.example.scheduleproject.domain.user.exception.PasswordMismatchedException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserSignUpResponseDto signUp(String username, String email, String password){

        User user = new User(username, email, password);

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

        return new UserResponseDto(findUser.getId(), findUser.getUsername(), findUser.getEmail());
    }

    public List<UserResponseDto> findAll(){
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }
    @Transactional
    public void updateUserEmail(Long id, String newEmail){
        User findUser = userRepository.findByIdOrElseThrow(id);

        findUser.updateUserEmail(newEmail);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public LoginResponseDto login(String email, String password){
        final User user = userRepository.findByEmail(email)
                .orElseThrow(()->new IllegalArgumentException("User not found. email = "+email));

        if(!user.getPassword().equals(password)){
            throw new PasswordMismatchedException("Password is inorrect. email = "+email);
        }
        return LoginResponseDto.of(user);
    }
}
