package jokardoo.eventmanager.dto;

import jakarta.persistence.Transient;
import jokardoo.eventmanager.domain.notification.ChangeFields;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class NotificationDto {
    private Long eventId;

    private ChangeFields changeFields;

    public NotificationDto(
            Long eventId,
            ChangeFields changeFields) {

        this.eventId = eventId;
        this.changeFields = changeFields;
    }
}
