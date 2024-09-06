package mirkoabozzi.U5S5L5.services;

import mirkoabozzi.U5S5L5.entities.Booking;
import mirkoabozzi.U5S5L5.exceptions.NotFoundException;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingsService {
    @Autowired
    private BookingsRepository bookingsRepository;

    public void saveBooking(Booking booking) {
        if (bookingsRepository.existsByBookingDateAndUser(booking.getBookingDate(), booking.getUser()) | bookingsRepository.existsByBookingDateAndWorkstation(booking.getBookingDate(), booking.getWorkstation()))
            throw new ValidationException("La prenotazione esiste già per l'utente in questa data o in questa postazione");
        bookingsRepository.save(booking);
        System.out.println("Prenotazione creata con successo");
    }

    public Booking findById(UUID id) {
        return bookingsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(UUID id) {
        bookingsRepository.delete(this.findById(id));
        System.out.println("Prenotazione con id " + id + " eliminata");
    }


}
// & bookingsRepository.existsByUser(booking.getUser()