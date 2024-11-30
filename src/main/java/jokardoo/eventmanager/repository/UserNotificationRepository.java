package jokardoo.eventmanager.repository;

import jokardoo.eventmanager.domain.notification.userNotification.UserNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotificationEntity, Long> {

    @Query(value = """
            SELECT * FROM user_notification_entity
            WHERE user_id = :userId 
            AND is_read = :isRead
            """, nativeQuery = true)
    List<UserNotificationEntity> findByUserIdAndIsRead(@Param("userId") Long userId, @Param("isRead") Boolean isRead);

}
