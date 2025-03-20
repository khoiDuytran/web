package ttcs_project.FitnessWebsite.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Dùng thay private
public class AuthenticationRequest {
    String username;
    String password;
}
