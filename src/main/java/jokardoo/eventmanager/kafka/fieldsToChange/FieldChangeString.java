package jokardoo.eventmanager.kafka.fieldsToChange;

import lombok.Data;

@Data
public class FieldChangeString {
    private String oldValue;
    private String newValue;
}
