package jokardoo.eventmanager.domain.notification;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class Notification {

    private Long id;

    private Long eventId;

    private Long updatedByUserId;

    private Long eventOwnerId;

    private List<ChangeFields> changeFields;

    private LocalDateTime notificationCreatedTime;

    public Notification(Long id, Long eventId, Long updatedByUserId, Long eventOwnerId, List<ChangeFields> changeFields) {
        this.id = id;
        this.eventId = eventId;
        this.updatedByUserId = updatedByUserId;
        this.eventOwnerId = eventOwnerId;
        this.changeFields = changeFields;
        this.notificationCreatedTime = LocalDateTime.now();
    }

    public Notification() {

    }
}
