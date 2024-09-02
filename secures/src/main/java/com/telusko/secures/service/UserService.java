package com.telusko.secures.service;

import com.telusko.secures.model.Data;
import com.telusko.secures.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;


//    plain to hashing .
//    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
//
//    public Data register(Data data) {
//        data.setPassword(encoder.encode(data.getPassword()));
//        return repo.save(data);

//    }

    private BCryptPasswordEncoder encoder1 = new BCryptPasswordEncoder(12);

    public Data register(Data data) {
        data.setPassword(encoder1.encode(data.getPassword()));
        return repo.save(data);

    }


    public String verify(Data data) {
        Authentication authentication =
                authManager.authenticate
                        (new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));

        if (authentication.isAuthenticated())
            return jwtService.generateToken(data.getUsername());

        return "fail";
    }
}

