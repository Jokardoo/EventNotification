package jokardoo.eventmanager.domain.notification.userNotification;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserNotificationPrimaryKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "notification_id")
    private Long notificationId;

    public UserNotificationPrimaryKey(Long userId, Long notificationId) {
        this.userId = userId;
        this.notificationId = notificationId;
    }

    public UserNotificationPrimaryKey() {

    }
}
