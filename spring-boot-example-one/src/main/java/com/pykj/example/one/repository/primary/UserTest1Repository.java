package com.pykj.example.one.repository.primary;

import com.pykj.example.one.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTest1Repository extends JpaRepository<Users, Long> {
    Users findByUserName(String userName);
    Users findByUserNameOrEmail(String username, String email);
}