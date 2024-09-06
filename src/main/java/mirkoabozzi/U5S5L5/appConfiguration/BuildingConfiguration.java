package mirkoabozzi.U5S5L5.appConfiguration;

import mirkoabozzi.U5S5L5.WorkstationType;
import mirkoabozzi.U5S5L5.entities.Building;
import mirkoabozzi.U5S5L5.entities.Workstation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BuildingConfiguration {


    @Bean
    public Building getBuilding() {
        Building building = new Building();
        building.setAddress("Via Nazionale");
        building.setCity("Roma");
        building.setName("Colosseo");

        return building;
    }

    @Bean
    public Building getBuilding2() {
        Building building = new Building();
        building.setAddress("Via roma");
        building.setCity("Milano");
        building.setName("Duomo");

        return building;
    }

    @Bean
    public Workstation getWorkstation() {
        Workstation workstation = new Workstation();
        workstation.setWorkstationType(WorkstationType.OPENSPACE);
        workstation.setOccupantsNumber(100);
        workstation.setDescription("100 seat workstation");

        return workstation;
    }

    @Bean
    public Workstation getWorkstation2() {
        Workstation workstation = new Workstation();
        workstation.setWorkstationType(WorkstationType.PRIVATE);
        workstation.setOccupantsNumber(60);
        workstation.setDescription("60 seat workstation");

        return workstation;
    }
}
