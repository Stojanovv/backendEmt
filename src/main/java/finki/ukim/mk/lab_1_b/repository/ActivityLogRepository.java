package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {
}
