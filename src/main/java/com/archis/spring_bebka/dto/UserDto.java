package com.archis.spring_bebka.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class UserDto {

    private Long id;

    @NotBlank(message = "This field cannot be left blank")
    @Size(min = 1, max = 50)
    private String username;

    @NotBlank(message = "EThis field cannot be left blank.")
    @Email(message = "Please enter a valid email address.")
    private String email;
}
