package jokardoo.eventmanager.domain.notification;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "change_fields")
public class ChangeFieldsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String fieldName;

    private String oldValue;

    private String newValue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    private NotificationEntity notificationEntity;

}
