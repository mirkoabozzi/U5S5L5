package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String username;
    private String name;
    private String surname;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Booking> bookingList;
}
