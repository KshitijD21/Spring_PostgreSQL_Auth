package com.auth.authentication.service;

import com.auth.authentication.model.UserPrinciple;
import com.auth.authentication.model.Users;
import com.auth.authentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepo.findByUserName(username);

        if (user == null) {
            System.out.println("User not found for username: " + username);
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("User found: " + user);
        return new UserPrinciple(user);
    }


}
