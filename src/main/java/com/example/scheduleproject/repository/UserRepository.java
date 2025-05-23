package com.example.scheduleproject.repository;

import com.example.scheduleproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
