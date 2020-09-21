package com.iouser.sorting.plantdata.service;

import com.iouser.sorting.plantdata.model.User;
import com.iouser.sorting.plantdata.repository.UserRepository;
import com.iouser.sorting.plantdata.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean addUser(User user) {
        boolean isAdded = Boolean.FALSE;
        user.setRole("ADMIN");
        user.setPassword(Helper.bCryptEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        if (userRepository.save(user)!=null){
            isAdded = Boolean.TRUE;
        }
        return isAdded;
    }
}
