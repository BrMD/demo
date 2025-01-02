package com.example.demo.usecase;

import org.springframework.security.core.userdetails.UserDetails;

public interface LoginUserUseCase {
    UserDetails loadUserByUsername(String login);
}
