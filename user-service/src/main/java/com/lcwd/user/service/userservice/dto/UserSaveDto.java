package com.lcwd.user.service.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveDto {
    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "about is required")
    @Size(min = 10, message = "About must be between 10 and 200 characters")
    private String about;

    @NotBlank(message = "email must not be blank")
    @Email(message = "Email should be valid")
    private String email;

}
