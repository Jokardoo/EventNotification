package jokardoo.eventmanager.domain.notification;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Notification {

    private Long id;

    private Long eventId;

    private Long updatedByUserId;

    private Long eventOwnerId;

    private String stringOfChanges;

    private LocalDateTime notificationCreatedTime;

    public Notification(Long id, Long eventId, Long updatedByUserId, Long eventOwnerId, String stringOfChanges) {
        this.id = id;
        this.eventId = eventId;
        this.updatedByUserId = updatedByUserId;
        this.eventOwnerId = eventOwnerId;
        this.stringOfChanges = stringOfChanges;
        this.notificationCreatedTime = LocalDateTime.now();
    }

    public Notification() {

    }
}
