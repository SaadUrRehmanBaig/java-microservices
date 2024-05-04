package com.lcwd.user.service.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSaveDto {
    @NotBlank(message = "Name is required")
    @Min(3)
    private String name;

    @NotBlank(message = "about is required")
    @Min(10)
    private String about;

    @NotBlank(message = "email must not be blank")
    @Email(message = "Email should be valid")
    private String email;

}
