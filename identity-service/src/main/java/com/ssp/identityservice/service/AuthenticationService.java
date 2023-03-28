package com.ssp.identityservice.service;

import com.ssp.identityservice.entity.UserCredentials;
import com.ssp.identityservice.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserCredentialsRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String addUser(UserCredentials credentials){
        credentials.setPassword(passwordEncoder.encode(credentials.getPassword()));
        repository.save(credentials);
        return "User Added";
    }

    public String generateToken(String userName){
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token){
        jwtService.validateToken(token);
    }
}
