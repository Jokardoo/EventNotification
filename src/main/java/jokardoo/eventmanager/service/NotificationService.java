package jokardoo.eventmanager.service;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import jokardoo.eventmanager.mapper.entityToModel.NotificationModelEntityMapper;
import jokardoo.eventmanager.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {


    private final NotificationModelEntityMapper modelEntityMapper;
    private final NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        if (notification.getStringOfChanges() == null || notification.getStringOfChanges().equals("")) {
            throw new IllegalArgumentException("There have been no changes in this notification");
        }
        notification.setNotificationCreatedTime(LocalDateTime.now());
        NotificationEntity createdNotification = notificationRepository.save(modelEntityMapper.toEntity(notification));
        return modelEntityMapper.toModel(createdNotification);
    }


    public List<Notification> getAllByNotificationCreatedTimeBefore(LocalDateTime dateTime) {
        return modelEntityMapper
                .toModel(
                        notificationRepository
                                .findAllByNotificationCreatedTimeBefore(dateTime)
                );
    }

    public void deleteNotification(Notification notification) {
        notificationRepository.delete(modelEntityMapper.toEntity(notification));
    }




}
