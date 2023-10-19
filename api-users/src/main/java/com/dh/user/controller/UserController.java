package com.dh.user.controller;

import com.dh.user.dto.UserLoginDto;
import com.dh.user.model.User;
import com.dh.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    ResponseEntity<User> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }
    @PostMapping("/")
    ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    @PostMapping("/login")
    ResponseEntity<Map<String, String>> login(@RequestBody UserLoginDto user) {
        Map<String, String> token = Map.of("token", userService.login(user));
        return ResponseEntity.ok().body(token);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByUsername(@PathVariable String username) {
        userService.deleteByUsername(username);
        return "User deleted";
    }
}
