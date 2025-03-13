package com.testapi.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.testapi.testapi.models.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByName(String username);
}
