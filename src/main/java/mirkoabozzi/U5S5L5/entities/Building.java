package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
@Data
public class Building {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building")
    private List<Workstation> workstationList;
}
