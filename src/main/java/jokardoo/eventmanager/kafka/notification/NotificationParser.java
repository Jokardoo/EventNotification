package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.domain.notification.ChangeFields;
import jokardoo.eventmanager.domain.notification.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationParser {

    public List<ChangeFields> parseAndReturnChangeFields(EventChangeNotification changes) {
        List<ChangeFields> changeFields = new ArrayList<>();

        if (changes.getName().hasActualData()) {
            changeFields.add(new ChangeFields("name",
                    changes.getName().getOldValue(),
                    changes.getName().getNewValue()));
        }
        if (changes.getMaxPlaces().hasActualData()) {
            changeFields.add(new ChangeFields("max_places",
                    changes.getMaxPlaces().getOldValue().toString(),
                    changes.getMaxPlaces().getNewValue().toString()));
        }

        if (changes.getOccupiedPlaces().hasActualData()) {
            changeFields.add(new ChangeFields("occupied_places",
                    changes.getOccupiedPlaces().getOldValue().toString(),
                    changes.getOccupiedPlaces().getNewValue().toString()));
        }

        if (changes.getDate().hasActualData()) {
            changeFields.add(new ChangeFields("date",
                    changes.getDate().getOldValue().toString(),
                    changes.getDate().getNewValue().toString()));
        }

        if (changes.getCost().hasActualData()) {
            changeFields.add(new ChangeFields("cost",
                    changes.getCost().getOldValue().toString(),
                    changes.getCost().getNewValue().toString()));
        }

        if (changes.getDuration().hasActualData()) {
            changeFields.add(new ChangeFields("duration",
                    changes.getDuration().getOldValue().toString(),
                    changes.getDuration().getNewValue().toString()));
        }

        if (changes.getLocationId().hasActualData()) {
            changeFields.add(new ChangeFields("LocationId",
                    changes.getLocationId().getOldValue().toString(),
                    changes.getLocationId().getNewValue().toString()));
        }

        if (changes.getStatus().hasActualData()) {
            changeFields.add(new ChangeFields("status",
                    changes.getStatus().getOldValue().toString(),
                    changes.getStatus().getNewValue().toString()));
        }

        return changeFields;
    }

    public Notification parseNotification(EventChangeNotification eventChanges) {
        Notification notification = new Notification();

        notification.setEventId(eventChanges.getEventId());
        notification.setEventOwnerId(eventChanges.getEventOwnerId());
        notification.setUpdatedByUserId(eventChanges.getUserId());
        notification.setNotificationCreatedTime(LocalDateTime.now());

        notification.setChangeFields(parseAndReturnChangeFields(eventChanges));

        return notification;
    }

    public boolean isNotificationHaveActualDataToSave(Notification notification) {
        List<ChangeFields> changeFields = notification.getChangeFields();

        for (ChangeFields cf : changeFields) {
            if (!cf.getNewValue()
                    .equals(cf.getOldValue())) {
                return true;
            }
        }
        return false;
    }


}
