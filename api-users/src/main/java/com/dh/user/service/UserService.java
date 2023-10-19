package com.dh.user.service;

import com.dh.user.dto.UserLoginDto;
import com.dh.user.model.User;
import com.dh.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteByUsername(String username) {
        User u = this.findByUsername(username);

        userRepository.delete(u);
    }

    public String login(UserLoginDto user) {
        try {
            User u = this.findByUsername(user.getUsername());
            if (u.getPassword().equals(user.getPassword())) {
                return "tfghjfr678iokjhgvcvbjkio87654";
            }
        } finally {
            throw new RuntimeException("invalid user or password");
        }
    }
}
