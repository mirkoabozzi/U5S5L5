package mirkoabozzi.U5S5L5.ruenners;

import mirkoabozzi.U5S5L5.entities.User;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {
        User mirko = new User("mirko.abozzi", "Mirko", "Abozzi", "mirko.abozzi@email.it");
        User giulia = new User("giulia.rossi", "Giulia", "Rossi", "giulia.rossi@email.it");
        User marco = new User("marco.bianchi", "Marco", "Bianchi", "marco.bianchi@email.it");
        User alessia = new User("alessia.verdi", "Alessia", "Verdi", "alessia.verdi@email.it");

        try {
//            usersService.saveUser(mirko);
//            usersService.saveUser(giulia);
//            usersService.saveUser(marco);
//            usersService.saveUser(alessia);
        } catch (ValidationException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
