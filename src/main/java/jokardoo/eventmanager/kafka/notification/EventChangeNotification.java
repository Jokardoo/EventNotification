package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.domain.event.EventStatus;
import jokardoo.eventmanager.kafka.fieldsToChange.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class EventChangeNotification {

    private Long eventId;

    private Long userId;

    private Long eventOwnerId;

    private boolean isEventNew;


    private FieldChange<String> name;

    private FieldChange<Integer> maxPlaces;

    private FieldChange<Integer> occupiedPlaces;

    private FieldChange<LocalDateTime> date;

    private FieldChange<Integer> cost;

    private FieldChange<Integer> duration;

    private FieldChange<Long> locationId;

    private FieldChange<EventStatus> status;


    private List<Long> subscribersIdList;


    public EventChangeNotification() {

    }
}