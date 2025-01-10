package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.BadCredentialsException;


@Getter
@Setter
public class CustomAuthenticationException extends BadCredentialsException {
    public CustomAuthenticationException(String msg) {
        super("Login or password wrong");
    }
}
