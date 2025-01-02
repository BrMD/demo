package com.example.demo.service;


import com.example.demo.repositories.DemoRepository;
import com.example.demo.usecase.LoginUserUseCase;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginImpl implements LoginUserUseCase, UserDetailsService {
    private final DemoRepository demoRepository;

    public LoginImpl(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var demo = demoRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println(demo.getUsername());
        System.out.println(demo.getPassword());
        return User.withUsername(demo.getUsername()).password(demo.getPassword()).build();
    }
}
