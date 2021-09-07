package com.api.controlfood.controller.dto.request;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRequest {
    @Email(message = "{validation.invalid.email}")
    @NotBlank(message = "{validation.blank}")
    private String email;

    @Size(min = 8, max = 16, message = "{validation.size}")
    @NotBlank(message = "{validation.blank}")
    private String password;
}
