package com.ssp.identityservice.controller;

import com.ssp.identityservice.dto.AuthRequest;
import com.ssp.identityservice.entity.UserCredentials;
import com.ssp.identityservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredentials userCredentials){
        return authenticationService.addUser(userCredentials);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return authenticationService.generateToken(authRequest.getUserName());
        }else {
            throw new RuntimeException("user invalid access");
        }

    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authenticationService.validateToken(token);
        return "Token is valid";
    }
}
