package jokardoo.eventmanager.domain.notification.userNotification;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_notification_entity")
public class UserNotificationEntity {

    @EmbeddedId
    private UserNotificationPrimaryKey userNotificationPrimaryKey;

    private Boolean isRead;

    public UserNotificationEntity() {

    }

    public UserNotificationEntity(UserNotificationPrimaryKey userNotificationPrimaryKey, Boolean isRead) {
        this.userNotificationPrimaryKey = userNotificationPrimaryKey;
        this.isRead = isRead;
    }
}
