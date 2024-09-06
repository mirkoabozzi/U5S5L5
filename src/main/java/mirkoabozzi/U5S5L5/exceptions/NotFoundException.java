package mirkoabozzi.U5S5L5.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("ID " + id + " non trovato nel DB");
    }
}
