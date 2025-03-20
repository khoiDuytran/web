package ttcs_project.FitnessWebsite.entity;


import java.time.LocalDate;

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
@Table(name = "member")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    String name;
    LocalDate startDate;
    LocalDate endDate;
    Boolean status; //còn hiệu lực hay không
    String description;
    Double price;
}
