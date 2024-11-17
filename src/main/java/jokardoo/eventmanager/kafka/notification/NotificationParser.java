package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.domain.notification.Notification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationParser {

    public String parseStringOfChanges(EventChangeNotification eventChanges) {

        if (eventChanges.isEventNew())
            return getStringOfChangesForNewEvent(eventChanges);

        StringBuilder sb = new StringBuilder();

        if (isNameChanged(eventChanges)) {
            sb.append("Event name was changed from '")
                    .append(eventChanges.getName().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getName().getNewValue())
                    .append("'; \n");
        }


        if (isMaxPlacesChanged(eventChanges)) {
            sb.append("Value of max places was changed from '")
                    .append(eventChanges.getMaxPlaces().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getMaxPlaces().getNewValue())
                    .append("'; \n");
        }

        if (isDateChanged(eventChanges)) {
            sb.append("Event date was changed from '")
                    .append(eventChanges.getDate().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getDate().getNewValue())
                    .append("'; \n");
        }

        if (isCostChanged(eventChanges)) {
            sb.append("Cost value was changed from '")
                    .append(eventChanges.getCost().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getCost().getNewValue())
                    .append("'; \n");
        }

        if (isDurationChanged(eventChanges)) {
            sb.append("Duration value was changed from '")
                    .append(eventChanges.getDuration().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getDuration().getNewValue())
                    .append("'; \n");
        }

        if (isLocationIdChanged(eventChanges)) {
            sb.append("Location id value was changed from '")
                    .append(eventChanges.getLocationId().getOldValue())
                    .append("' to '")
                    .append(eventChanges.getLocationId().getNewValue())
                    .append("'; \n");
        }

        if (isStatusChanged(eventChanges)) {
            sb.append("Event status was changed from '")
                    .append(eventChanges.getStatus().getOldValue().name())
                    .append("' to '").append(eventChanges.getStatus().getNewValue().name())
                    .append("'; \n");
        }

        return sb.toString();
    }

    private String getStringOfChangesForNewEvent(EventChangeNotification eventChanges) {

        return "Created new event with name '" + eventChanges.getName().getNewValue() +
                "';\n" +
                "Max places: '" + eventChanges.getMaxPlaces().getNewValue() +
                "'; \n" +
                "Date: '" + eventChanges.getDate().getNewValue() +
                "'; \n" +
                "Cost: '" + eventChanges.getCost().getNewValue() +
                "'; \n" +
                "Duration: '" + eventChanges.getDuration().getNewValue() +
                "'; \n" +
                "Location id: '" + eventChanges.getLocationId().getNewValue() +
                "'; \n";
    }

    private boolean isNameChanged(EventChangeNotification changes) {
        try {
            return !changes.getName().getOldValue()
                    .equals(changes.getName().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isMaxPlacesChanged(EventChangeNotification changes) {
        try {
            return !changes.getMaxPlaces().getOldValue()
                    .equals(changes.getMaxPlaces().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isDateChanged(EventChangeNotification changes) {
        try {
            return !changes.getDate().getOldValue()
                    .equals(changes.getDate().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isCostChanged(EventChangeNotification changes) {
        try {
            return !changes.getCost().getOldValue()
                    .equals(changes.getCost().getNewValue());
        }catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isDurationChanged(EventChangeNotification changes) {
        try {
            return !changes.getDuration().getOldValue()
                    .equals(changes.getDuration().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isLocationIdChanged(EventChangeNotification changes) {
        try {
            return !changes.getLocationId().getOldValue()
                    .equals(changes.getLocationId().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    private boolean isStatusChanged(EventChangeNotification changes) {
        try {
            return !changes.getStatus().getOldValue()
                    .equals(changes.getStatus().getNewValue());
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public Notification parseNotification(EventChangeNotification eventChanges) {
        Notification notification = new Notification();

        notification.setEventId(eventChanges.getEventId());
        notification.setEventOwnerId(eventChanges.getEventOwnerId());
        notification.setUpdatedByUserId(eventChanges.getUserId());
        notification.setNotificationCreatedTime(LocalDateTime.now());

        notification.setStringOfChanges(parseStringOfChanges(eventChanges));

        notification.setNotificationCreatedTime(LocalDateTime.now());


        return notification;
    }

    public boolean isNotificationHaveActualDataToSave(Notification notification) {
        String data = notification.getStringOfChanges();

        if (data.equals("") || data == null) {
            return false;
        }

        return true;
    }

}
