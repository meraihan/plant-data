package com.iouser.sorting.plantdata.service;

import com.iouser.sorting.plantdata.model.User;
import com.iouser.sorting.plantdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found.");
        }
        final String roleName = user.getRole();
        GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}
