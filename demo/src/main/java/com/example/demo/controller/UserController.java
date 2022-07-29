package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.impl.UserUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserUserServiceImpl userService;

    @PostMapping("/adduser")
    public Employee addUser(@RequestBody Employee employee) {
        return userService.insertUser(employee);
    }

    @PostMapping("/addusers")
    public List<Employee> addUsers(@RequestBody List<Employee> employees) {
        return userService.insertUsers(employees);
    }

    @GetMapping("/getUserById/{id}")
    public Employee getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public Employee updateUser(@RequestBody Employee u) {
        return userService.updateUser(u);
    }

    @DeleteMapping("/delete/{id}")
    public String Delete(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/getEmployeeAgeById/{id}")
    public Employee getEmployeeAge(@PathVariable int id) {
        return userService.getEmployeeAge(id);
    }
}
