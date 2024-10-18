package com.renvital.apirest.apirest.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.renvital.apirest.apirest.Entities.User;
import com.renvital.apirest.apirest.Repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public User getUserById(@PathVariable Integer id){
        return userRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("No se encontró el usuario con el ID" + id));
    }

    @PostMapping
    public User postUser(@RequestBody User user){
        // Verificar si el email ya existe en la base de datos
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
    
        if (existingUser.isPresent()) {
            // Si el usuario ya existe, devolver el usuario existente (continuar el inicio de sesión)
            return existingUser.get();
        }
    
        // Si el usuario no existe, guardarlo en la base de datos (registro)
        return userRepository.save(user);
    }


}
