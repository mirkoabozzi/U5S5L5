package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@ToString
public class Booking {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;
    @Column(name = "booking_date")
    private LocalDate bookingDate;

    public Booking(User user, Workstation workstation, LocalDate bookingDate) {
        this.user = user;
        this.workstation = workstation;
        this.bookingDate = bookingDate;
    }
}
