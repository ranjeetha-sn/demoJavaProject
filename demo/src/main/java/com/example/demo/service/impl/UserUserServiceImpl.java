package com.example.demo.service.impl;

import com.example.demo.entity.Employee;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class UserUserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    /**
     * @param employee
     * @return
     */
   
    public Employee insertUser(Employee employee) {
        return userRepository.save(employee);
    }

    //to save list of user
    public List<Employee> insertUsers(List<Employee> employeeList) {
        return userRepository.saveAll(employeeList);
    }

    //to get user by id get method

    public Employee getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    //to delete the user
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "user deleted succesfully" + id;
    }
    //to update the user update method

    public Employee updateUser(Employee employee) {
        Employee existingEmployee = userRepository.findById(employee.getId()).orElse(null);
        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setSalary(employee.getSalary());
        return userRepository.save(existingEmployee);
    }

    /**
     * get all user present in db
     */

    public List<Employee> getAllUser() {

        return userRepository.findAll();
    }

    public Employee getEmployeeAge(int id) {
        /**
         * userRepository.findById(id).orElse(null); this line gets all the entity of
         * employee based on the id presnt in it
         */
        Employee existingData = userRepository.findById(id).orElse(null);
        LocalDate date = existingData.getDateOfBirth();
        LocalDate localDate = LocalDate.now();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        int age = Period.between(date, localDate).getYears();
//        dto.setsalary(existingData.getSalary());
//        dto.setAge(age);
        return existingData;
    }
}

