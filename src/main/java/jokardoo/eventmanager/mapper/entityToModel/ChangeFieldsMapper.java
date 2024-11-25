package jokardoo.eventmanager.mapper.entityToModel;

import jokardoo.eventmanager.domain.event.EventStatus;
import jokardoo.eventmanager.domain.notification.ChangeFields;
import jokardoo.eventmanager.domain.notification.ChangeFieldsEntity;
import jokardoo.eventmanager.kafka.fieldsToChange.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class ChangeFieldsMapper {

    public ChangeFieldsEntity toEntity(ChangeFields changeFields) {
        ChangeFieldsEntity entity = new ChangeFieldsEntity();

        entity.setOldName(changeFields.getName().getOldValue());
        entity.setOldMaxPlaces(changeFields.getMaxPlaces().getOldValue());
        entity.setOldOccupiedPlaces(changeFields.getOccupiedPlaces().getOldValue());
        entity.setOldDate(changeFields.getDate().getOldValue());
        entity.setOldCost(changeFields.getCost().getOldValue());
        entity.setOldDuration(changeFields.getDuration().getOldValue());
        entity.setOldLocationId(changeFields.getLocationId().getOldValue());
        entity.setOldDuration(changeFields.getDuration().getOldValue());
        entity.setOldStatus(changeFields.getStatus().getOldValue().name());

        entity.setNewName(changeFields.getName().getNewValue());
        entity.setNewMaxPlaces(changeFields.getMaxPlaces().getNewValue());
        entity.setNewOccupiedPlaces(changeFields.getOccupiedPlaces().getNewValue());
        entity.setNewDate(changeFields.getDate().getNewValue());
        entity.setNewCost(changeFields.getCost().getNewValue());
        entity.setNewDuration(changeFields.getDuration().getNewValue());
        entity.setNewLocationId(changeFields.getLocationId().getNewValue());
        entity.setNewDuration(changeFields.getDuration().getNewValue());
        entity.setNewStatus(changeFields.getStatus().getNewValue().name());


        return entity;
    }

    public ChangeFields toModel(ChangeFieldsEntity entity) {


        FieldChange<String> name = new FieldChange<>();
        name.setOldValue(entity.getOldName());
        name.setNewValue(entity.getOldName());

        FieldChange<Integer> occupiedPlace = new FieldChange<>();
        occupiedPlace.setOldValue(entity.getOldOccupiedPlaces());
        occupiedPlace.setNewValue(entity.getNewOccupiedPlaces());

        FieldChange<Integer> maxPlaces = new FieldChange<>();
        maxPlaces.setOldValue(entity.getOldMaxPlaces());
        maxPlaces.setNewValue(entity.getNewMaxPlaces());

        FieldChange<LocalDateTime> dateTime = new FieldChange<>();
        dateTime.setOldValue(entity.getOldDate());
        dateTime.setNewValue(entity.getNewDate());

        FieldChange<Integer> cost = new FieldChange<>();
        cost.setOldValue(entity.getOldCost());
        cost.setNewValue(entity.getNewCost());

        FieldChange<Integer> duration = new FieldChange<>();
        duration.setOldValue(entity.getOldDuration());
        duration.setNewValue(entity.getNewDuration());

        FieldChange<Long> locationId = new FieldChange<>();
        locationId.setOldValue(entity.getOldLocationId());
        locationId.setNewValue(entity.getNewLocationId());

        FieldChange<EventStatus> status = new FieldChange<>();
        status.setOldValue(EventStatus.valueOf(entity.getOldStatus()));
        status.setNewValue(EventStatus.valueOf(entity.getNewStatus()));

        return new ChangeFields(name,
                maxPlaces,
                occupiedPlace,
                dateTime,
                cost,
                duration,
                locationId,
                status);
    }
}
