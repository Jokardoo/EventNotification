package jokardoo.eventmanager.mapper.modelToDto;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.dto.NotificationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationModelToDtoMapper implements ModelToDtoMapper<NotificationDto, Notification> {
    @Override
    public Notification toModel(NotificationDto dto) {
        return new Notification(dto.getId(),
                dto.getEventId(),
                dto.getUpdatedByUserId(),
                dto.getEventOwnerId(),
                dto.getStringOfChanges());
    }

    @Override
    public NotificationDto toDto(Notification model) {
        return new NotificationDto(model.getId(),
                model.getEventId(),
                model.getUpdatedByUserId(),
                model.getEventOwnerId(),
                model.getStringOfChanges(),
                model.getNotificationCreatedTime());
    }

    @Override
    public List<Notification> toModel(List<NotificationDto> dtoList) {
        List<Notification> notificationList = new ArrayList<>();

        for (NotificationDto notificationDto : dtoList) {
            notificationList.add(toModel(notificationDto));
        }

        return notificationList;
    }

    @Override
    public List<NotificationDto> toDto(List<Notification> modelList) {
        List<NotificationDto> notificationDtoList = new ArrayList<>();

        for (Notification notification : modelList) {
            notificationDtoList.add(toDto(notification));
        }

        return notificationDtoList;
    }
}
