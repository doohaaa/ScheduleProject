package com.example.scheduleproject.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name="user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column
    private String email;

    @Column
    private String password;

    public User(){}

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    public void updateUserEmail(String newEmail){
        this.email = newEmail;
    }






}
