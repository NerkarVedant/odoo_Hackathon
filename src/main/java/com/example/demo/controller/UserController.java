package com.example.demo.controller;

import com.example.demo.controller.dto.CreateUserRequest;
import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<AppUser> addUser(@RequestBody CreateUserRequest request) {
        AppUser created = userService.addUser(request.getName(), request.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public List<AppUser> listUsers() {
        return userService.listUsers();
    }
}
