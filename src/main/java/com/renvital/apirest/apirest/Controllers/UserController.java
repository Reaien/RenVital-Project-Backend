package com.renvital.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.renvital.apirest.apirest.Entities.User;
import com.renvital.apirest.apirest.Repositories.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/users")


public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró el usuario con el ID" + id));
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User putUser(@PathVariable Long id, @RequestBody User userDetails){
        return userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró el usuario con el ID" + id));

        
    }

}
