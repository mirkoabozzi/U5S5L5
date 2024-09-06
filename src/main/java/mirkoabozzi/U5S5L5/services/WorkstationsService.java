package mirkoabozzi.U5S5L5.services;

import mirkoabozzi.U5S5L5.entities.Workstation;
import mirkoabozzi.U5S5L5.repositories.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkstationsService {
    @Autowired
    private WorkstationRepository workstationRepository;

    public void saveWorkstation(Workstation workstation) {
        workstationRepository.save(workstation);
        System.out.println("Workstation " + workstation.getDescription() + " salvata con successo");
    }
}
