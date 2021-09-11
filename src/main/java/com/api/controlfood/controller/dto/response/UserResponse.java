package com.api.controlfood.controller.dto.response;

import com.api.controlfood.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String email;
    private String password;

    public static UserResponse fromUser(User user) {
        return new UserResponse(
                user.getEmail(),
                user.getPassword());
    }
}
