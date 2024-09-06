package mirkoabozzi.U5S5L5.ruenners;

import mirkoabozzi.U5S5L5.entities.Booking;
import mirkoabozzi.U5S5L5.entities.Building;
import mirkoabozzi.U5S5L5.entities.User;
import mirkoabozzi.U5S5L5.entities.Workstation;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.services.BookingsService;
import mirkoabozzi.U5S5L5.services.BuildingsService;
import mirkoabozzi.U5S5L5.services.UsersService;
import mirkoabozzi.U5S5L5.services.WorkstationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    private BookingsService bookingsService;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {

        Building building = (Building) ctx.getBean("getBuilding");
        Building building2 = (Building) ctx.getBean("getBuilding2");

        Building buildingFromDB = buildingsService.findById(UUID.fromString("24c7b583-3378-4d20-a167-19976b20819f"));
        Building buildingFromDB2 = buildingsService.findById(UUID.fromString("a8ff2dd4-d996-46e7-965d-751460ea4843"));

        Workstation workstation = (Workstation) ctx.getBean("getWorkstation");
        workstation.setBuilding(buildingFromDB);

        Workstation workstation2 = (Workstation) ctx.getBean("getWorkstation2");
        workstation2.setBuilding(buildingFromDB2);


        User mirko = new User("mirko.abozzi", "Mirko", "Abozzi", "mirko.abozzi@email.it");
        User giulia = new User("giulia.rossi", "Giulia", "Rossi", "giulia.rossi@email.it");
        User marco = new User("marco.bianchi", "Marco", "Bianchi", "marco.bianchi@email.it");
        User alessia = new User("alessia.verdi", "Alessia", "Verdi", "alessia.verdi@email.it");

        User mirkoFromDb = usersService.findById(UUID.fromString("47709093-43ec-4d4f-82d7-a8144f3dc55a"));
        User giuliaFromDb = usersService.findById(UUID.fromString("ad8eabe0-00f9-4945-98ab-376c70360450"));
        User marcoFromDb = usersService.findById(UUID.fromString("dd32d155-c1f5-44ec-a5ec-3d826c5fa00f"));
        User alessiaFromDb = usersService.findById(UUID.fromString("676210d3-103c-453b-a7fe-f52a273e7b48"));

        Workstation workstationFromDB = workstationsService.findById(UUID.fromString("adff7f54-1a8f-498f-a663-4e265d02e381"));
        Workstation workstation2FromDB = workstationsService.findById(UUID.fromString("535c81c6-3053-4b7a-bf14-f4052085cff6"));

        Booking booking = new Booking(mirkoFromDb, workstationFromDB, LocalDate.of(2024, 9, 6));
        Booking booking2 = new Booking(giuliaFromDb, workstation2FromDB, LocalDate.of(2024, 9, 7));
        Booking booking3 = new Booking(marcoFromDb, workstationFromDB, LocalDate.of(2024, 9, 8));


        workstationsService.findByType("OPENSPACE").forEach(System.out::println);

        try {
//            usersService.saveUser(mirko);
//            usersService.saveUser(giulia);
//            usersService.saveUser(marco);
//            usersService.saveUser(alessia);
//            buildingsService.saveBuilding(building);
//            buildingsService.saveBuilding(building2);
//            workstationsService.saveWorkstation(workstation);
//            workstationsService.saveWorkstation(workstation2);
//            bookingsService.saveBooking(booking);
//            bookingsService.saveBooking(booking2);
//            bookingsService.saveBooking(booking3);
        } catch (ValidationException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
