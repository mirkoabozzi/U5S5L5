package mirkoabozzi.U5S5L5.repositories;

import mirkoabozzi.U5S5L5.WorkstationType;
import mirkoabozzi.U5S5L5.entities.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {

    List<Workstation> findByWorkstationType(WorkstationType type);

}
