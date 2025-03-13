package com.testapi.testapi.models;

import jakarta.persistence.*; // Para JPA
import lombok.Data; // Opcional, ayuda a reducir código

@Entity
@Table(name = "users") // Nombre de la tabla en la BD
@Data // Lombok: genera getters, setters y toString automáticamente
public class User {

    public User(String email, String password, String name) {
        this.name = email;
        this.email = name;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
