package ttcs_project.FitnessWebsite.dto.request;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE) // Dùng thay private
public class RoleRequest {
    String name;
    String description;
    Set<String> permissions;
}
