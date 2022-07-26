package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userrepository;

    /**
     *
     * @param user
     * @return
     */

    public User insertUser(User user) {
        return userrepository.save(user);
    }

    //to save list of user
    public List<User> insertUsers(List<User> usr) {
        return userrepository.saveAll(usr);
    }

    //to get user by id get method

    public User getUserById(int id) {
        return userrepository.findById(id).orElse(null);
    }

    //to delete the user
    public String deleteUser(int id) {
        userrepository.deleteById(id);
        return "user deleted succesfully" + id;
    }
    //to update the user update method

    public User updateUser(User user) {
        User existingUser = userrepository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        return userrepository.save(existingUser);
    }

    //get all user present in db
    public List<User> getAllUser() {

        return userrepository.findAll();
    }
}

