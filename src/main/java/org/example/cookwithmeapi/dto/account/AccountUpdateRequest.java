package org.example.cookwithmeapi.dto.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateRequest {
    @Length(min = 2, message = "First name must be at least 3 characters")
    private String firstName;

    @Length(min = 2, message = "Last name must be at least 3 characters")
    private String lastName;
}
