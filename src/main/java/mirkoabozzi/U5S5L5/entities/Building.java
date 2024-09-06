package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buildings")
@Getter
@Setter
//@ToString

public class Building {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "building", fetch = FetchType.EAGER)
    private List<Workstation> workstationList;

    public Building() {
    }

    public Building(String name, String address, String city, List<Workstation> workstationList) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.workstationList = workstationList;
    }
}
