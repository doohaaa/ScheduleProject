package com.example.scheduleproject.domain.user.entity;

import com.example.scheduleproject.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String email;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public void updateUserEmail(String newEmail){
        this.email = newEmail;
    }

}
