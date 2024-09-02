package com.telusko.secures.service;


import com.telusko.secures.model.UserPrincipal;
import com.telusko.secures.model.Data;
import com.telusko.secures.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo Repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Data data = Repo.findByUsername(username);
        if (data == null) {
            System.out.println("user found");
            throw new UsernameNotFoundException("user not found");
        }
        return new UserPrincipal(data);
    }


}
