package com.dh.user.service;

import com.dh.user.model.User;
import com.dh.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public String deleteByUsername(String username) {
        User u = userRepository.findByUsername(username);

        if (u == null) {
            return "user does not exist";
        } else {
            userRepository.deleteByUsername(username);
            return "user deleted";
        }
    }
}
