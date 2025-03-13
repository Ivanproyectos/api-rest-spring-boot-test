package com.testapi.testapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.testapi.testapi.models.User;
import com.testapi.testapi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Guardar un usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Buscar por email
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
