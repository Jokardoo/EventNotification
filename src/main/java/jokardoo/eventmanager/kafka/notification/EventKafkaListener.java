package jokardoo.eventmanager.kafka.notification;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.domain.notification.userNotification.UserNotificationPrimaryKey;
import jokardoo.eventmanager.service.NotificationService;
import jokardoo.eventmanager.service.UserNotificationService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class EventKafkaListener {

    private final NotificationParser notificationParser;

    private final UserNotificationService userNotificationService;

    private final NotificationService notificationService;

    private final Logger logger = LoggerFactory.getLogger(EventKafkaListener.class);

    // Spring автоматически будет слушать события из кафки
    @KafkaListener(topics = "event-topic", containerFactory = "containerFactory")
    public void listenEvents(ConsumerRecord<Long, EventChangeNotification> record) {
        EventChangeNotification eventChanges = record.value();

        Notification notification = notificationParser.parseNotification(eventChanges);

        if (notificationParser.isNotificationHaveActualDataToSave(notification)) {
            Notification curNotification = notificationService.save(notification);

            notifyUsersAboutEventChanges(eventChanges, curNotification);
        }

        logger.info("Get change event: event{}", record.value());
    }

    private void notifyUsersAboutEventChanges(EventChangeNotification eventChanges, Notification notification) {
        if (eventChanges.getSubscribersIdList() != null) {

            for (Long subscriberId : eventChanges.getSubscribersIdList()) {
                UserNotification userNotification = new UserNotification();

                userNotification
                        .setUserNotificationPrimaryKey(
                                new UserNotificationPrimaryKey(
                                        subscriberId,
                                        notification.getId()
                                )
                        );
                userNotification.setIsRead(false);

                userNotificationService.save(userNotification);
            }
        }
    }

}
