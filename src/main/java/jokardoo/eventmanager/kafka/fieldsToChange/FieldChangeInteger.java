package jokardoo.eventmanager.kafka.fieldsToChange;

import lombok.Data;

@Data
public class FieldChangeInteger {
    private Integer oldValue;
    private Integer newValue;
}
