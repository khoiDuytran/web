package ttcs_project.FitnessWebsite.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import ttcs_project.FitnessWebsite.validator.DobConstraint;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Dùng thay private
public class UserCreationRequest {
    @Size(min = 7, max = 255, message = "USERNAME_INVALID")
    String username;

    @Size(min = 6, max = 255, message = "PASSWORD_INVALID")
    String password;

    String firstName;
    String lastName;

    @DobConstraint(min = 14, message = "DOB_INVALID")
    LocalDate dob;
}
