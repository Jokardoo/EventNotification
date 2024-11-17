package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.kafka.fieldsToChange.*;
import lombok.Data;

import java.util.List;

@Data
public class EventChangeNotification {

    private Long eventId;

    private Long userId;

    private Long eventOwnerId;

    private boolean isEventNew;


    private FieldChangeString name;

    private FieldChangeInteger maxPlaces;

    private FieldChangeInteger occupiedPlaces;

    private FieldChangeDateTime date;

    private FieldChangeInteger cost;

    private FieldChangeInteger duration;

    private FieldChangeLong locationId;

    private FieldChangeEventStatus status;


    private List<Long> subscribersIdList;


    public EventChangeNotification() {

    }
}