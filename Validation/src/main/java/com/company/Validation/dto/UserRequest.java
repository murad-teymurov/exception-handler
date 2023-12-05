package com.company.Validation.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "name should not be null.")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
