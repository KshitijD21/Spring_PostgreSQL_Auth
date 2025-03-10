package com.auth.authentication.service;

import com.auth.authentication.model.Users;
import com.auth.authentication.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserRepo repo;

    private AuthenticationManager authenticationManager;

    @Autowired
    public UserService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    private JWTService jwtService;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);


    public Users register (Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users users) {
        System.out.println("Inside verify");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(users.getUserName(), users.getPassword())
            );

            System.out.println("authentication.isAuthenticated(): " + authentication.isAuthenticated());

            if (authentication.isAuthenticated()) {

                return jwtService.generateToken(users.getUserName());
            }

        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            e.printStackTrace(); // This will print the full error details
        }

        return "fail";
    }

    public List<Users> getAllUsers() {

      List<Users> allData  = repo.findAll();
        System.out.println(" allData " + allData);



        return allData;

    }
}
