package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AppUserRepository appUserRepository;

    public AppUser addUser(String name, String email) {
        AppUser user = new AppUser();
        user.setName(name);
        user.setEmail(email);
        user.setCreatedAt(OffsetDateTime.now());
        return appUserRepository.save(user);
    }

    public List<AppUser> listUsers() {
        return appUserRepository.findAll();
    }
}
