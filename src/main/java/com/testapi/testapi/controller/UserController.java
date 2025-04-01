package com.testapi.testapi.controller;

import com.testapi.testapi.contracts.Requests.CreateUserDto;
import com.testapi.testapi.contracts.dtos.UserDto;
import com.testapi.testapi.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.testapi.testapi.services.UserService;
import com.testapi.testapi.services.FileStorageService;
import com.testapi.testapi.Dtos.PagedResult;


import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileStorageService fileStorageService;

    private final Path rootLocation = Paths.get("archivos");

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
    public User createUser(@Valid  @RequestBody CreateUserDto user) {
        return userService.saveUser(new User(user.getEmail(), user.getPassword(), user.getName()));
    }

        @PostMapping("upload")
    public ResponseEntity createUserFile(@Valid  @ModelAttribute CreateUserDto user) {

            try {
                var file = user.getFile();
                 fileStorageService.store(file);
                var newUser = userService.saveUser(new User(user.getEmail(), user.getPassword(), user.getName()));
                return ResponseEntity.ok().body(newUser);
            } catch (IOException e) {
                return ResponseEntity.status(500).body("Error al subir el archivo.");
            }
    }
    @GetMapping("paged")
    public ResponseEntity<PagedResult<UserDto>> getUserPaged (
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10")  int size,
            @RequestParam()  String email,
            @RequestParam()  String name
    ) {

       var user = userService.getUserPaged(page, size, email, name);
       return ResponseEntity.ok().body(user);
    }

}
