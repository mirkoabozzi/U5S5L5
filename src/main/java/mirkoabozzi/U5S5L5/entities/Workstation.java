package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mirkoabozzi.U5S5L5.WorkstationType;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workstations")
@Getter
@Setter
@ToString
public class Workstation {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private WorkstationType workstationType;
    private Integer occupantsNumber;

    @OneToMany(mappedBy = "workstation")
    private List<Booking> bookingList;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation() {
    }

    public Workstation(String description, WorkstationType workstationType, Integer occupantsNumber) {
        this.description = description;
        this.workstationType = workstationType;
        this.occupantsNumber = occupantsNumber;
    }
}
