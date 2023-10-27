package com.dh.user.controller;

import com.dh.user.dto.UserLoginDto;
import com.dh.user.model.Provider;
import com.dh.user.model.User;
import com.dh.user.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/{username}")
    ResponseEntity<Provider> getByUsername(@PathVariable String provider) {
        return ResponseEntity.ok().body(providerService.findByUsername(provider));
    }
    @PostMapping("/")
    ResponseEntity<Provider> saveProvider(@RequestBody Provider provider) {
        return ResponseEntity.ok().body(providerService.save(provider));
    }

    @PostMapping("/login")
    ResponseEntity<Map<String, String>> login(@RequestBody UserLoginDto provider) {
        Map<String, String> token = Map.of("token", providerService.login(provider));
        return ResponseEntity.ok().body(token);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteByUsername(@PathVariable String username) {
        providerService.deleteByUsername(username);
        return "User deleted";
    }
}
