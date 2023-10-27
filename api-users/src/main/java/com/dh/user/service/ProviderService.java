package com.dh.user.service;

import com.dh.user.dto.UserLoginDto;
import com.dh.user.model.Provider;
import com.dh.user.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider findByUsername(String username) {
        return providerRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("user not found"));
    }

    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    public void deleteByUsername(String username) {
        Provider p = this.findByUsername(username);

        providerRepository.delete(p);
    }

    public String login(UserLoginDto user) {
        try {
            Provider p = this.findByUsername(user.getUsername());
            if (p.getPassword().equals(user.getPassword())) {
                return "tfghjfr678iokjhgvcvbjkio87654";
            }
        } finally {
            throw new RuntimeException("invalid user or password");
        }
    }
}
