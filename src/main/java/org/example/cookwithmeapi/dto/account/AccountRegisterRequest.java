package org.example.cookwithmeapi.dto.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRegisterRequest {

    @NotBlank(message = "Username is mandatory")
    @Length(min = 3, message = "Username must be at least 3 characters")
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    @Length(min = 2, message = "First name must be at least 2 characters")
    private String firstName;

    @Length(min = 2, message = "Last name must be at least 2 characters")
    private String lastName;

    @NotBlank(message = "Password is mandatory")
    @Length(min = 6, message = "Password must be at least 6 characters")
    private String password;
}
