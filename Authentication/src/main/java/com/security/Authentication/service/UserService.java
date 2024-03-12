package com.security.Authentication.service;

import com.security.Authentication.models.AppUser;
import com.security.Authentication.models.Role;
import com.security.Authentication.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the UserService");

        return userRepo.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException ("Invalid User"));


//        if(!username.equals("Ethan")) throw new UsernameNotFoundException("Not Ethan");
//        Set<Role> roles = new HashSet<>();
//        roles.add(new Role(60,"USER"));
//
//        return new AppUser(60, "Ethan", encoder.encode("password"), roles);

    }
}
