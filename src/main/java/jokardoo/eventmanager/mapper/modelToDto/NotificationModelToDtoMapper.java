package jokardoo.eventmanager.mapper.modelToDto;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.dto.NotificationDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;



@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface NotificationModelToDtoMapper extends ModelToDtoMapper<NotificationDto, Notification> {

}
