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
@Table(name = "checkin_checkout")
public class Checkin {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    Membership membership;

    LocalDate checkInTime;
    LocalDate checkOutTime;
    String status;
}
