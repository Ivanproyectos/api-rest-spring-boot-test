package com.testapi.testapi.controller;

import com.testapi.testapi.Dtos.UserDto;
import com.testapi.testapi.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.testapi.testapi.services.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        if(user.isEmpty()){
            return ResponseEntity.status(404).body(Map.of("message", "User does not exist"));
        }

        return ResponseEntity.ok(user);
    }
    // Guardar un nuevo usuario
    @PostMapping
    public User createUser(@Valid  @RequestBody UserDto user) {
        return userService.saveUser(new User(user.getEmail(), user.getPassword(), user.getName()));
    }

}
