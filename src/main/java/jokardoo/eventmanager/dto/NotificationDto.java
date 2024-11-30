package jokardoo.eventmanager.dto;

import jokardoo.eventmanager.domain.notification.ChangeFields;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class NotificationDto {
    private Long eventId;

    private List<ChangeFields> changeFields;



}
