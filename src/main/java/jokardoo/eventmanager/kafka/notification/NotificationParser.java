package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.domain.notification.ChangeFields;
import jokardoo.eventmanager.domain.notification.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationParser {

    public ChangeFields parseChangeFields(EventChangeNotification changes) {
        ChangeFields changeFields = new ChangeFields();

        changeFields.setName(changes.getName());
        changeFields.setMaxPlaces(changes.getMaxPlaces());
        changeFields.setOccupiedPlaces(changes.getOccupiedPlaces());

        changeFields.setDate(changes.getDate());
        changeFields.setCost(changes.getCost());
        changeFields.setDuration(changes.getDuration());
        changeFields.setLocationId(changes.getLocationId());
        changeFields.setStatus(changes.getStatus());

        return changeFields;
    }

    public Notification parseNotification(EventChangeNotification eventChanges) {
        Notification notification = new Notification();

        notification.setEventId(eventChanges.getEventId());
        notification.setEventOwnerId(eventChanges.getEventOwnerId());
        notification.setUpdatedByUserId(eventChanges.getUserId());
        notification.setNotificationCreatedTime(LocalDateTime.now());

        notification.setChangeFields(parseChangeFields(eventChanges));

        notification.setNotificationCreatedTime(LocalDateTime.now());


        return notification;
    }

    public boolean isNotificationHaveActualDataToSave(Notification notification) {
        ChangeFields changeFields = notification.getChangeFields();

        if (changeFields.getName().hasActualData()
                || changeFields.getMaxPlaces().hasActualData()
                || changeFields.getOccupiedPlaces().hasActualData()
                || changeFields.getDate().hasActualData()
                || changeFields.getCost().hasActualData()
                || changeFields.getDuration().hasActualData()
                || changeFields.getLocationId().hasActualData()
                || changeFields.getStatus().hasActualData()) {
            return true;
        }
        return false;
    }


}
