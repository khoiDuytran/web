package ttcs_project.FitnessWebsite.entity;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "gym_equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    String type;
    String description;
    String status;
}
