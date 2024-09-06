package mirkoabozzi.U5S5L5.repositories;

import mirkoabozzi.U5S5L5.entities.Booking;
import mirkoabozzi.U5S5L5.entities.User;
import mirkoabozzi.U5S5L5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, UUID> {

    boolean existsByBookingDateAndUser(LocalDate localDate, User user);

    boolean existsByBookingDateAndWorkstation(LocalDate localDate, Workstation workstation);

}
