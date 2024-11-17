package jokardoo.eventmanager.dto;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotificationPrimaryKey;
import lombok.Data;

@Data
public class UserNotificationDto {

    private UserNotificationPrimaryKey userNotificationPrimaryKey;

    private Boolean isRead;

    public UserNotificationDto(UserNotificationPrimaryKey userNotificationPrimaryKey, Boolean isRead) {
        this.userNotificationPrimaryKey = userNotificationPrimaryKey;
        this.isRead = isRead;
    }
}
