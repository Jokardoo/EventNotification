package jokardoo.eventmanager.domain.notification;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

    private String stringOfChanges;

    private LocalDateTime notificationCreatedTime;

    public NotificationEntity() {
    }

    public NotificationEntity(Long id,
                              Long eventId,
                              Long updatedByUserId,
                              Long eventOwnerId,
                              String stringOfChanges) {
        this.id = id;
        this.eventId = eventId;
        this.updatedByUserId = updatedByUserId;
        this.eventOwnerId = eventOwnerId;
        this.stringOfChanges = stringOfChanges;
        this.notificationCreatedTime = LocalDateTime.now();
    }
}
