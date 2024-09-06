package mirkoabozzi.U5S5L5.ruenners;

import mirkoabozzi.U5S5L5.entities.Building;
import mirkoabozzi.U5S5L5.entities.User;
import mirkoabozzi.U5S5L5.entities.Workstation;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.services.BuildingsService;
import mirkoabozzi.U5S5L5.services.UsersService;
import mirkoabozzi.U5S5L5.services.WorkstationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private UsersService usersService;
    @Autowired
    private BuildingsService buildingsService;
    @Autowired
    private WorkstationsService workstationsService;

    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        Building building = (Building) ctx.getBean("getBuilding");
//        buildingsService.saveBuilding(building);

        Building buildingDB = buildingsService.findById(UUID.fromString("24c7b583-3378-4d20-a167-19976b20819f"));

        Workstation workstation = (Workstation) ctx.getBean("getWorkstation");
        workstation.setBuilding(buildingDB);
//        workstationsService.saveWorkstation(workstation);

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
