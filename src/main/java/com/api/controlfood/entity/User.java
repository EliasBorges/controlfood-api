package com.api.controlfood.entity;

import com.api.controlfood.controller.dto.request.UserRequest;
import com.api.controlfood.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(updatable = false, unique = true, nullable = false, name = "id_user")
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public static String create(UserRequest request, UserRepository repository) {
        return repository.save(new User(
                UUID.randomUUID().toString(),
                request.getEmail(),
                request.getPassword())
        ).id;
    }
}
