package jokardoo.eventmanager.kafka.fieldsToChange;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FieldChangeDateTime {
    private LocalDateTime oldValue;
    private LocalDateTime newValue;
}
