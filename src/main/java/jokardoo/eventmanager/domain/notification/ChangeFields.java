package jokardoo.eventmanager.domain.notification;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChangeFields {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long notificationId;

    private String fieldName;

    private String oldValue;

    private String newValue;

    @JsonIgnore
    private Notification notification;

    public ChangeFields(String fieldName, String oldValue, String newValue) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
