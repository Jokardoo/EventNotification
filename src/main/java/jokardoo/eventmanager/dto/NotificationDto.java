package jokardoo.eventmanager.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificationDto {
    private Long id;

    private Long eventId;

    private Long updatedByUserId;

    private Long eventOwnerId;

    private String stringOfChanges;


    private LocalDateTime notificationCreatedTime;

    public NotificationDto(Long id,
                           Long eventId,
                           Long updatedByUserId,
                           Long eventOwnerId,
                           String stringOfChanges,
                           LocalDateTime notificationCreatedTime) {
        this.id = id;
        this.eventId = eventId;
        this.updatedByUserId = updatedByUserId;
        this.eventOwnerId = eventOwnerId;
        this.stringOfChanges = stringOfChanges;
        this.notificationCreatedTime = notificationCreatedTime;
    }
}
