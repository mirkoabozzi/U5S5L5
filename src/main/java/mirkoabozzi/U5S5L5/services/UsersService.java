package mirkoabozzi.U5S5L5.services;

import mirkoabozzi.U5S5L5.entities.User;
import mirkoabozzi.U5S5L5.exceptions.NotFoundException;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public void saveUser(User user) {
        if (usersRepository.existsByEmail(user.getEmail()))
            throw new ValidationException("Utente con email " + user.getEmail() + " è già presente nel DB");
        usersRepository.save(user);
        System.out.println("Nuovo utente " + user.getUsername() + " salvato con successo");
    }

    public User findById(UUID id) {
        return usersRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(UUID id) {
        usersRepository.delete(this.findById(id));
        System.out.println("User " + this.findById(id).getUsername() + " eliminato");
    }

    public void update(UUID id, User newUser) {
        User found = this.findById(id);
        found.setName(newUser.getName());
        found.setSurname(newUser.getSurname());
        found.setUsername(newUser.getUsername());
        found.setEmail(newUser.getEmail());
        usersRepository.save(found);
    }
}
