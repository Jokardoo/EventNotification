package jokardoo.eventmanager.kafka.fieldsToChange;

import lombok.Data;

@Data
public class FieldChangeLong {
    private Long oldValue;
    private Long newValue;
}
