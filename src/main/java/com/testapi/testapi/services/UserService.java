package com.testapi.testapi.services;

import com.testapi.testapi.contracts.dtos.UserDto;
import com.testapi.testapi.specifications.UserSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.testapi.testapi.models.User;
import com.testapi.testapi.repository.UserRepository;
import com.testapi.testapi.mappers.UserMapper;
import com.testapi.testapi.Dtos.PagedResult;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private final UserMapper userMapper = UserMapper.INSTANCE;

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

    public PagedResult<UserDto> getUserPaged(int page, int size, String email, String name) {

        Pageable pegeable = PageRequest.of(page, size);

        Specification<User> spec = Specification
                .where(UserSpecifications.hasEmailLike(email))
                .and(UserSpecifications.hasName(name));

        var result = userRepository.findAll(spec, pegeable);
        var userDto = userMapper.userPageToUsersPageResult(result);
        return userDto;
    }

}
