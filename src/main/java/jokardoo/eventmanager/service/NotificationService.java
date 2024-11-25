package jokardoo.eventmanager.service;

import jokardoo.eventmanager.domain.notification.ChangeFieldsEntity;
import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import jokardoo.eventmanager.kafka.notification.NotificationParser;
import jokardoo.eventmanager.mapper.entityToModel.ChangeFieldsMapper;
import jokardoo.eventmanager.mapper.entityToModel.NotificationModelEntityMapper;
import jokardoo.eventmanager.repository.ChangeFieldRepository;
import jokardoo.eventmanager.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final ChangeFieldsMapper changeFieldsMapper;
    private final ChangeFieldRepository changeFieldRepository;
    private final NotificationModelEntityMapper modelEntityMapper;
    private final NotificationRepository notificationRepository;


    private final NotificationParser notificationParser;

    public Notification save(Notification notification) {

        if (!notificationParser.isNotificationHaveActualDataToSave(notification)) {
            throw new IllegalArgumentException("There have been no changes in this notification");
        }

        ChangeFieldsEntity savedChangeFields = changeFieldRepository.save(changeFieldsMapper.toEntity(notification.getChangeFields()));
        notification.setChangeFields(changeFieldsMapper.toModel(savedChangeFields));

        notification.setNotificationCreatedTime(LocalDateTime.now());
        NotificationEntity entityToSave = modelEntityMapper.toEntity(notification);
        NotificationEntity createdNotification = notificationRepository.save(entityToSave);
        return modelEntityMapper.toModel(createdNotification);
    }

    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        List<NotificationEntity> notificationEntities = notificationRepository.findUnreadNotificationsByUserId(userId);

        return modelEntityMapper.toModel(notificationEntities);
    }


    public void deleteAllNotificationsWhereCreatedTimeBefore(LocalDateTime dateTime) {
        notificationRepository.deleteAllByNotificationCreatedTimeBefore(dateTime);
    }


}
