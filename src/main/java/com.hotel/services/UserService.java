package com.hotel.services;

import com.hotel.data.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User registerUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();
}
