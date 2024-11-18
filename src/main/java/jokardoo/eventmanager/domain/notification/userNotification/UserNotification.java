package jokardoo.eventmanager.domain.notification.userNotification;

import lombok.Data;

@Data
public class UserNotification {
    private UserNotificationPrimaryKey userNotificationPrimaryKey;

    private Boolean isRead;

    public UserNotification(UserNotificationPrimaryKey userNotificationPrimaryKey, Boolean isRead) {
        this.userNotificationPrimaryKey = userNotificationPrimaryKey;
        this.isRead = isRead;
    }

    public UserNotification() {

    }
}
