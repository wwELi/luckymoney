package com.example.luckymoney.controller;

import com.example.luckymoney.aspect.HttpAspect;
import com.example.luckymoney.model.User;
import com.example.luckymoney.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User u1 = User.builder()
                .userName(user.getUserName())
                .build();

        logger.info("*******" + user.getId() + "******" +user.getGroups());

        return userRepository.save(user);
    }
}
