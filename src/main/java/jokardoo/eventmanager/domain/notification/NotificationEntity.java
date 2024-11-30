package jokardoo.eventmanager.domain.notification;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Long updatedByUserId;

    private Long eventOwnerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationEntity")
    private List<ChangeFieldsEntity> changeFieldsEntity;

    private LocalDateTime notificationCreatedTime;



}
