package jokardoo.eventmanager.mapper.modelToDto;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.dto.UserNotificationDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserNotificationModelToDtoMapper implements ModelToDtoMapper<UserNotificationDto, UserNotification>{
    @Override
    public UserNotification toModel(UserNotificationDto dto) {
        return new UserNotification(dto.getUserNotificationPrimaryKey(), dto.getIsRead());
    }

    @Override
    public UserNotificationDto toDto(UserNotification model) {
        return new UserNotificationDto(model.getUserNotificationPrimaryKey(), model.getIsRead());
    }

    @Override
    public List<UserNotification> toModel(List<UserNotificationDto> dtoList) {

        List<UserNotification> userNotifications = new ArrayList<>();

        for (UserNotificationDto dto : dtoList) {
            userNotifications.add(toModel(dto));
        }

        return userNotifications;

    }

    @Override
    public List<UserNotificationDto> toDto(List<UserNotification> modelList) {

        List<UserNotificationDto> userNotificationsDto = new ArrayList<>();

        for (UserNotification model : modelList) {
            userNotificationsDto.add(toDto(model));
        }

        return userNotificationsDto;


    }
}
