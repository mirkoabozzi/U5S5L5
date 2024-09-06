package mirkoabozzi.U5S5L5.services;

import mirkoabozzi.U5S5L5.entities.Building;
import mirkoabozzi.U5S5L5.exceptions.NotFoundException;
import mirkoabozzi.U5S5L5.exceptions.ValidationException;
import mirkoabozzi.U5S5L5.repositories.BuildingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BuildingsService {
    @Autowired
    private BuildingsRepository buildingsRepository;

    public void saveBuilding(Building building) {
        if (buildingsRepository.existsByName(building.getName()))
            throw new ValidationException("La struttura con nome " + building.getName() + " è già presente nel DB");
        buildingsRepository.save(building);
        System.out.println("Struttura " + building.getName() + " creata con successo");
    }

    public Building findById(UUID id) {
        return buildingsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(UUID id) {
        buildingsRepository.delete(this.findById(id));
        System.out.println("Struttura " + this.findById(id).getName() + " eliminata");
    }

}
