package jokardoo.eventmanager.repository;

import jokardoo.eventmanager.domain.notification.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {


    @Query(value = """
            SELECT * from notification n 
            LEFT JOIN user_notification_entity une on n.id = une.notification_id 
            WHERE une.is_read = false 
            AND une.user_id = :userId
                        """, nativeQuery = true)
    List<NotificationEntity> findUnreadNotificationsByUserId(@Param("userId") Long userId);

    void deleteAllByNotificationCreatedTimeBefore(LocalDateTime dateTime);

}
