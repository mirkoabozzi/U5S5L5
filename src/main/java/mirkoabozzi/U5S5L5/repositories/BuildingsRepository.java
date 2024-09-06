package mirkoabozzi.U5S5L5.repositories;

import mirkoabozzi.U5S5L5.entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BuildingsRepository extends JpaRepository<Building, UUID> {

    boolean existsByName(String name);
}
