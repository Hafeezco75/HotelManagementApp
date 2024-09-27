package com.hotel.controller;

import com.hotel.Dto.LoginRequest;
import com.hotel.data.models.User;
import com.hotel.services.AuthenticateUser;
import com.hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    AuthenticateUser authenticateUser;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authenticateUser.login(username, password);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authenticateUser.login(loginRequest);
    }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/api/features")
    public String getFeatures() {
        return "This is a public feature available to everyone.";
    }

    // Admin-only endpoint
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/api/admin/manage")
    public String manageUsers() {
        return "Welcome Admin! You can manage users here.";
    }

    // User-only endpoint
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/api/user/profile")
    public String getUserProfile() {
        return "Welcome User! Here is your profile.";
    }
}

