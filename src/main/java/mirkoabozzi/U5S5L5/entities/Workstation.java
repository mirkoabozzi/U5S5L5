package mirkoabozzi.U5S5L5.entities;

import jakarta.persistence.*;
import lombok.Data;
import mirkoabozzi.U5S5L5.WorkstationType;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "workstations")
@Data
public class Workstation {
    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private WorkstationType workstationType;
    private Integer occupantsNumber;

    @OneToMany(mappedBy = "workstation")
    private List<Booking> bookingList;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
