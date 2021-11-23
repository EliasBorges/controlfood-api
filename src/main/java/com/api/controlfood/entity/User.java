package com.api.controlfood.entity;

import com.api.controlfood.controller.dto.request.user.UserRequest;
import com.api.controlfood.controller.dto.request.user.UserUpdateRequest;
import com.api.controlfood.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_user")
public class User {
    @Id
    @Column(updatable = false, unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public static String create(
            UserRequest request,
            UserRepository repository,
            PasswordEncoder passwordEncoder
    ) {
        return repository.save(new User(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()))
        ).id;
    }

    public String update(
            UserUpdateRequest request,
            UserRepository repository,
            PasswordEncoder passwordEncoder
    ) {
        this.name = request.getName();
        this.password = passwordEncoder.encode(request.getPassword());

        return repository.save(this).id;
    }

    public void delete(
            UserRepository repository
    ) {
        repository.delete(this);
    }
}
