package jokardoo.eventmanager.repository;

import jokardoo.eventmanager.domain.notification.ChangeFieldsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeFieldRepository extends JpaRepository<ChangeFieldsEntity, Long> {
}
