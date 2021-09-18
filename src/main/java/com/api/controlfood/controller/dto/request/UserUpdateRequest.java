package com.api.controlfood.controller.dto.request;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserUpdateRequest {
    @NotBlank(message = "{validation.blank}")
    private String name;

    @Size(min = 8, max = 16, message = "{validation.size}")
    @NotBlank(message = "{validation.blank}")
    private String password;
}
