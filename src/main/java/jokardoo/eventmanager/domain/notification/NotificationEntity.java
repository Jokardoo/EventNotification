package jokardoo.eventmanager.domain.notification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notification")
@AllArgsConstructor
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;

    private Long updatedByUserId;

    private Long eventOwnerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "change_fields_id", referencedColumnName = "id")
    private ChangeFieldsEntity changeFieldsEntity;

    private LocalDateTime notificationCreatedTime;

    public NotificationEntity() {
    }


}
