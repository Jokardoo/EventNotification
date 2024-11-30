package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.notification.ChangeFields;
import jokardoo.eventmanager.domain.notification.ChangeFieldsEntity;
import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.NotificationEntity;
import org.mapstruct.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = NotificationModelEntityMapper.class)
public interface ChangeFieldsModelEntityMapper extends ModelEntityMapper<ChangeFields, ChangeFieldsEntity> {


    @Mappings(
            @Mapping(target = "notificationEntity", source = "notification", qualifiedByName = "notificationModelToEntity", ignore = true)
    )
    ChangeFieldsEntity toEntity(ChangeFields changeFields);

    @Named("notificationModelToEntity")
    NotificationEntity notificationModelToEntity(NotificationEntity notificationEntity);



    @Mappings(
            @Mapping(target = "notification", source = "notificationEntity", qualifiedByName = "notificationEntityToModel", ignore = true)
    )
    ChangeFields toModel(ChangeFieldsEntity changeFieldsEntity);

    @Named("notificationEntityToModel")
    Notification notificationEntityToModel(NotificationEntity notificationEntity);



}


