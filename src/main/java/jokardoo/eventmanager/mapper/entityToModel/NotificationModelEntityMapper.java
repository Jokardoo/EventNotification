package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.notification.ChangeFields;
import jokardoo.eventmanager.domain.notification.ChangeFieldsEntity;
import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = ChangeFieldsModelEntityMapper.class)
public interface NotificationModelEntityMapper extends ModelEntityMapper<Notification, NotificationEntity> {


    @Mapping(target = "changeFields", source = "changeFieldsEntity", qualifiedByName = "changeFieldsEntityListToModel")
    Notification toModel(NotificationEntity notificationEntity);

    @Named("changeFieldsEntityListToModel")
    List<ChangeFields> changeFieldsEntityListToModel(List<ChangeFieldsEntity> changeFieldsEntities);


    @Mappings(
            @Mapping(target = "changeFieldsEntity", source = "changeFields", qualifiedByName = "changeFieldsListToEntity")
    )
    NotificationEntity toEntity(Notification notification);

    @Named("changeFieldsListToEntity")
    List<ChangeFieldsEntity> changeFieldsListToEntity(List<ChangeFields> changeFields);
}
