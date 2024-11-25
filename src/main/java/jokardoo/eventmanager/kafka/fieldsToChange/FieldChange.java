package jokardoo.eventmanager.kafka.fieldsToChange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldChange<T> {
    private T oldValue;
    private T newValue;

    public boolean hasActualData() {
        return !oldValue.equals(newValue);
    }

}
