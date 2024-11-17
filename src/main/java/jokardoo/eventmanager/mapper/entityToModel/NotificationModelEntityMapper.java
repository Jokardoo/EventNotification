package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationModelEntityMapper implements ModelEntityMapper<Notification, NotificationEntity>{
    @Override
    public Notification toModel(NotificationEntity entity) {
        return new Notification(
                entity.getId(),
                entity.getEventId(),
                entity.getUpdatedByUserId(),
                entity.getEventOwnerId(),
                entity.getStringOfChanges()
        );
    }

    @Override
    public NotificationEntity toEntity(Notification model) {
        return new NotificationEntity(
                model.getId(),
                model.getEventId(),
                model.getUpdatedByUserId(),
                model.getEventOwnerId(),
                model.getStringOfChanges()
        );
    }

    @Override
    public List<Notification> toModel(List<NotificationEntity> entityList) {
        List<Notification> notificationList = new ArrayList<>();

        for (NotificationEntity entity : entityList) {
            notificationList.add(toModel(entity));
        }
        return notificationList;
    }

    @Override
    public List<NotificationEntity> toEntity(List<Notification> modelList) {
        List<NotificationEntity> notificationEntityList = new ArrayList<>();

        for (Notification model : modelList) {
            notificationEntityList.add(toEntity(model));
        }
        return notificationEntityList;
    }
}
