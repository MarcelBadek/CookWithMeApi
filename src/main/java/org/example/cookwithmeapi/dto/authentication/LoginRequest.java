package org.example.cookwithmeapi.dto.authentication;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    @NotBlank(message = "Username is mandatory")
    @Length(min = 3, message = "Username must be at least 3 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Length(min = 6, message = "Password must be at least 6 characters")
    private String password;
}
