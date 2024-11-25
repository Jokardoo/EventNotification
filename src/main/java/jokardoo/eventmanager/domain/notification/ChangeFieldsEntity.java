package jokardoo.eventmanager.domain.notification;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "change_fields")
public class ChangeFieldsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "changeFieldsEntity", cascade = CascadeType.ALL)
    private NotificationEntity notification;

    private String oldName;

    private Integer oldMaxPlaces;

    private Integer oldOccupiedPlaces;

    private LocalDateTime oldDate;

    private Integer oldCost;

    private Integer oldDuration;

    private Long oldLocationId;

    private String oldStatus;




    private String newName;

    private Integer newMaxPlaces;

    private Integer newOccupiedPlaces;

    private LocalDateTime newDate;

    private Integer newCost;

    private Integer newDuration;

    private Long newLocationId;

    private String newStatus;



    public ChangeFieldsEntity() {

    }
}
