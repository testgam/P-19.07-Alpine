package me.m11m.p1907.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.m11m.p1907.configuration.SecurityUtil;
import me.m11m.p1907.model.MyUser;
import me.m11m.p1907.repository.UserRepository;

/**
 * MyUserService
 */
@Service
public class MyUserService {

    @Autowired
    UserRepository userRepository;

    

    public MyUser registerUser(MyUser myUser) throws Exception{
        String enc = SecurityUtil.sha256(myUser.getPassword());
        myUser.setPassword(enc);

        return userRepository.save(myUser);
    }
}