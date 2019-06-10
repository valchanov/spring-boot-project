package com.example.hello.service;

import com.example.hello.model.User;
import com.example.hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //If we do not use RDBMS
//    private List<User> users = new ArrayList<>(Arrays.asList(
//            new User(1, "admin1", "Apple",  "admin"),
//            new User(2, "admin2", "AWS",  "admin"),
//            new User(3, "chintan", "Sony", "FE")
//    ));

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Optional<User> getUser(int id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
