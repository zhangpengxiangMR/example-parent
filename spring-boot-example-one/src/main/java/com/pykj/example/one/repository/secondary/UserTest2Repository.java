package com.pykj.example.one.repository.secondary;

import com.pykj.example.one.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTest2Repository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
    Users findByUserNameOrEmail(String username, String email);
}