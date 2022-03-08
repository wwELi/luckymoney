package com.example.luckymoney.controller;

import com.example.luckymoney.model.Group;
import com.example.luckymoney.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @GetMapping("/groups")
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @PostMapping("/groups")
    public Group createUser(@RequestBody Group group) {

        return groupRepository.save(group);
    }
}
