package jokardoo.eventmanager.service;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.mapper.entityToModel.UserNotificationModelEntityMapper;
import jokardoo.eventmanager.repository.UserNotificationRepository;
import jokardoo.eventmanager.service.utils.AuthenticationParser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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



    public void readUserNotificationsByNotificationIds(List<Long> notificationIdList) {

        List<UserNotification> userNotifications = userNotificationModelEntityMapper
                .toModel(userNotificationRepository
                        .findByUserIdAndIsRead(authenticationParser.getCurrentUserId(), false));

        List<UserNotification> filteredUserNotifications = new ArrayList<>();

        for (UserNotification un : userNotifications) {
            if (notificationIdList.contains(un.getUserNotificationPrimaryKey().getNotificationId())) {
                un.setIsRead(true);
                filteredUserNotifications.add(un);
            }
        }

        userNotificationRepository.saveAll(userNotificationModelEntityMapper.toEntity(filteredUserNotifications));
    }
}
