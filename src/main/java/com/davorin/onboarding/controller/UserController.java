package com.davorin.onboarding.controller;

import com.davorin.onboarding.model.User;
import com.davorin.onboarding.service.FormService;
import com.davorin.onboarding.service.ProcessService;
import com.davorin.onboarding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @DeleteMapping("/remove")
    public void removeUser(@RequestParam Long id) {
        userService.removeUser(id);
    }
}
