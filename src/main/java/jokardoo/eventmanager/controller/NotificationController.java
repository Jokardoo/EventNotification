package jokardoo.eventmanager.controller;

import jokardoo.eventmanager.domain.notification.Notification;
import jokardoo.eventmanager.domain.notification.userNotification.UserNotification;
import jokardoo.eventmanager.dto.NotificationDto;
import jokardoo.eventmanager.dto.UserNotificationDto;
import jokardoo.eventmanager.mapper.modelToDto.NotificationModelToDtoMapper;
import jokardoo.eventmanager.mapper.modelToDto.UserNotificationModelToDtoMapper;
import jokardoo.eventmanager.service.NotificationService;
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

    private final NotificationModelToDtoMapper notificationModelToDtoMapper;

    private final NotificationService notificationService;


    @GetMapping()
    public ResponseEntity<List<NotificationDto>> getAllUnreadNotifications() {


        List<Notification> notificationList = notificationService
                .getUnreadNotificationsByUserId(authenticationParser.getCurrentUserId());

        List<NotificationDto> notificationDtoList = notificationModelToDtoMapper.toDto(notificationList);

        return ResponseEntity.status(200).body(notificationDtoList);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> readUserNotifications(@RequestBody Map<String,List<Long>> notificationIdList) {

        userNotificationService.
                readUserNotificationsByNotificationIds(notificationIdList.get("notificationIdList"));

        return new ResponseEntity(HttpStatus.OK);


    }
}
