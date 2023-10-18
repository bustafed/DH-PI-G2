package com.dh.user.controller;

import com.dh.user.model.User;
import com.dh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{username}")
    ResponseEntity<User> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(userService.findByUsername(username));
    }
    @PostMapping("/")
    ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok().body(userService.save(user));
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }
}
