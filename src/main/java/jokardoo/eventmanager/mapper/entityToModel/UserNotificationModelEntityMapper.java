package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.domain.notification.userNotification.UserNotificationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserNotificationModelEntityMapper implements ModelEntityMapper<UserNotification, UserNotificationEntity> {
    @Override
    public UserNotification toModel(UserNotificationEntity entity) {
        return new UserNotification(
                entity.getUserNotificationPrimaryKey(),
                entity.getIsRead()
        );
    }

    @Override
    public UserNotificationEntity toEntity(UserNotification model) {
        return new UserNotificationEntity(
                model.getUserNotificationPrimaryKey(),
                model.getIsRead());
    }

    @Override
    public List<UserNotification> toModel(List<UserNotificationEntity> entityList) {

        List<UserNotification> userNotifications = new ArrayList<>();

        for (UserNotificationEntity entity : entityList) {
            userNotifications.add(toModel(entity));
        }

        return userNotifications;
    }

    @Override
    public List<UserNotificationEntity> toEntity(List<UserNotification> modelList) {

        List<UserNotificationEntity> userNotificationEntities = new ArrayList<>();

        for (UserNotification model : modelList) {
            userNotificationEntities.add(toEntity(model));
        }

        return userNotificationEntities;
    }
}
