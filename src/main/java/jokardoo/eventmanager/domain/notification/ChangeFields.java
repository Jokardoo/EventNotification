package jokardoo.eventmanager.domain.notification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jokardoo.eventmanager.domain.event.EventStatus;
import jokardoo.eventmanager.kafka.fieldsToChange.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ChangeFields {

    @JsonIgnore
    private Long Id;


    private FieldChange<String> name;

    private FieldChange<Integer> maxPlaces;

    private FieldChange<Integer> occupiedPlaces;

    private FieldChange<LocalDateTime> date;

    private FieldChange<Integer> cost;

    private FieldChange<Integer> duration;

    private FieldChange<Long> locationId;

    private FieldChange<EventStatus> status;

    public ChangeFields(FieldChange<String> name,
                        FieldChange<Integer> maxPlaces,
                        FieldChange<Integer> occupiedPlaces,
                        FieldChange<LocalDateTime> date,
                        FieldChange<Integer> cost,
                        FieldChange<Integer> duration,
                        FieldChange<Long> locationId,
                        FieldChange<EventStatus> status) {
        this.name = name;
        this.maxPlaces = maxPlaces;
        this.occupiedPlaces = occupiedPlaces;
        this.date = date;
        this.cost = cost;
        this.duration = duration;
        this.locationId = locationId;
        this.status = status;
    }
}
