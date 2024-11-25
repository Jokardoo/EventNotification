package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class NotificationModelEntityMapper implements ModelEntityMapper<Notification, NotificationEntity>{

    private final ChangeFieldsMapper changeFieldsMapper;

    @Override
    public Notification toModel(NotificationEntity entity) {
        return new Notification(
                entity.getId(),
                entity.getEventId(),
                entity.getUpdatedByUserId(),
                entity.getEventOwnerId(),
                changeFieldsMapper.toModel(entity.getChangeFieldsEntity())
        );
    }

    @Override
    public NotificationEntity toEntity(Notification model) {
        return new NotificationEntity(model.getId(),
                model.getEventId(),
                model.getUpdatedByUserId(),
                model.getEventOwnerId(),
                changeFieldsMapper.toEntity(model.getChangeFields()),
                model.getNotificationCreatedTime());
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
