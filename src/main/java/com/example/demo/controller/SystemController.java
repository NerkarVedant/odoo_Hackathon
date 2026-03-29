package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String rootCheck() {
        return "App is running!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/handshake")
    public Map<String, Object> handshake() {
        List<AppUser> users = userService.listUsers();
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Handshake successful");
        response.put("users", users);
        return response;
    }
}
