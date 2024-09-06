package mirkoabozzi.U5S5L5.repositories;

import mirkoabozzi.U5S5L5.WorkstationType;
import mirkoabozzi.U5S5L5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {

    List<Workstation> findByWorkstationType(WorkstationType type);

    @Query("SELECT w FROM Workstation w WHERE w.workstationType = :workstationType AND w.building.city = :city")
    List<Workstation> findByWorkstationTypeAndCity(WorkstationType workstationType, String city);

}
