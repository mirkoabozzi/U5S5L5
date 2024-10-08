package mirkoabozzi.U5S5L5.services;

import mirkoabozzi.U5S5L5.WorkstationType;
import mirkoabozzi.U5S5L5.entities.Workstation;
import mirkoabozzi.U5S5L5.exceptions.NotFoundException;
import mirkoabozzi.U5S5L5.repositories.WorkstationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkstationsService {
    @Autowired
    private WorkstationRepository workstationRepository;

    public void saveWorkstation(Workstation workstation) {
        workstationRepository.save(workstation);
        System.out.println("Workstation " + workstation.getDescription() + " salvata con successo");
    }

    public Workstation findById(UUID id) {
        return workstationRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(UUID id) {
        workstationRepository.delete(this.findById(id));
        System.out.println("Workstation con id " + id + " eliminata");
    }

    public List<Workstation> findByType(String type) {
        return workstationRepository.findByWorkstationType(WorkstationType.valueOf(type));
    }

    public List<Workstation> findWorkstationTypeAndCity(String type, String city) {

        List<Workstation> found = workstationRepository.findByWorkstationTypeAndCity(WorkstationType.valueOf(type), city);
        if (found.isEmpty()) System.out.println("Nessuna postazione trovata");
        return found;
    }
}
