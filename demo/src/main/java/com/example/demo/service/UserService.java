package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;


public interface UserService {


    Employee insertUser(Employee employee);

    List<Employee> insertUsers(List<Employee> employeeList);

    Employee getUserById(int id);

    String deleteUser(int id);

    Employee updateUser(Employee employee);

    List<Employee> getAllUser();

     Employee getEmployeeAge(int id);

}
