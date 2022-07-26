package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PostMapping("/addusers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.insertUsers(users);
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User u) {
        return userService.updateUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
}
