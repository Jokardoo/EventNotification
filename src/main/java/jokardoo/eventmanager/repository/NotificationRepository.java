package jokardoo.eventmanager.repository;

import jokardoo.eventmanager.domain.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

    Optional<NotificationEntity> findById(Long id);

    List<NotificationEntity> findAllByNotificationCreatedTimeBefore(LocalDateTime dateTime);



}
