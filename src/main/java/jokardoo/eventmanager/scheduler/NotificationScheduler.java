package jokardoo.eventmanager.scheduler;

import jokardoo.eventmanager.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@Configuration
@RequiredArgsConstructor
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class NotificationScheduler {
    private final Logger logger = LoggerFactory.getLogger(NotificationScheduler.class);

    @Value("${app.notification-expiration-date}")
    private Long expirationDateInHours;

    private final NotificationService notificationService;

    @Scheduled(cron = "0/5 * * * * *")
    public void deleteExpiredNotifications() {
        logger.info("INFO: Deleting old records");

        notificationService.deleteAllNotificationsWhereCreatedTimeBefore(
                LocalDateTime
                .now()
                .minusHours(expirationDateInHours)
        );

    }

}
