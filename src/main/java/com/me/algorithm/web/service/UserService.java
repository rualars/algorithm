package com.me.algorithm.web.service;

import com.me.algorithm.web.entity.User;
import com.me.algorithm.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUid(Integer uid) {
        return userRepository.getByUid(uid);
    }

}
