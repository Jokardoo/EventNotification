package jokardoo.eventmanager.service;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.mapper.entityToModel.UserNotificationModelEntityMapper;
import jokardoo.eventmanager.repository.UserNotificationRepository;
import jokardoo.eventmanager.service.utils.AuthenticationParser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserNotificationService {

    private final Logger logger = LoggerFactory.getLogger(UserNotificationService.class);
    private final UserNotificationRepository userNotificationRepository;

    private final UserNotificationModelEntityMapper userNotificationModelEntityMapper;

    private final AuthenticationParser authenticationParser;

    public void save(UserNotification userNotification) {
        logger.info("INFO: try to save userNotification.");

        userNotificationModelEntityMapper.toModel(
                userNotificationRepository
                        .save(userNotificationModelEntityMapper.toEntity(userNotification))
        );
    }

    public List<UserNotification> getUnreadUserNotifications(Long id) {
        logger.info("INFO: try to get unread user notifications by user id.");
        return userNotificationModelEntityMapper.toModel(userNotificationRepository.findUnreadNotificationsByUserId(id));
    }

    public void readUserNotificationsByNotificationIds(List<Long> notificationIdList) {
        notificationIdList.stream().forEach(notificationId -> {
            UserNotification userNotification = userNotificationModelEntityMapper
                    .toModel(userNotificationRepository
                            .findUnreadNotificationsByNotificationIdAndUserId(
                                    notificationId, authenticationParser.getCurrentUserId()
                            ));
            userNotification.setIsRead(true);
            userNotificationRepository
                    .save(userNotificationModelEntityMapper.toEntity(userNotification));
        });
    }
}
