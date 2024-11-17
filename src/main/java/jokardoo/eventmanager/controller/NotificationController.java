package jokardoo.eventmanager.controller;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.dto.UserNotificationDto;
import jokardoo.eventmanager.mapper.modelToDto.UserNotificationModelToDtoMapper;
import jokardoo.eventmanager.service.UserNotificationService;
import jokardoo.eventmanager.service.utils.AuthenticationParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final AuthenticationParser authenticationParser;

    private final UserNotificationService userNotificationService;

    private final UserNotificationModelToDtoMapper userNotificationModelToDtoMapper;


    @GetMapping()
    public ResponseEntity<List<UserNotificationDto>> getAllUnreadNotifications() {

        List<UserNotification> userNotificationList = userNotificationService
                .getUnreadUserNotifications(
                        authenticationParser
                                .getCurrentUserId()
                );


        return ResponseEntity.status(200).body(userNotificationModelToDtoMapper
                .toDto(userNotificationList));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> readUserNotifications(@RequestBody Map<String,List<Long>> notificationIdList) {

        userNotificationService.
                readUserNotificationsByNotificationIds(notificationIdList.get("notificationIdList"));

        return new ResponseEntity(HttpStatus.OK);


    }
}
