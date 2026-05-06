package finki.ukim.mk.lab_1_b.service.domain;

import finki.ukim.mk.lab_1_b.model.domain.ActivityLog;
import org.springframework.data.domain.Page;

public interface ActivityLogService {
    public Page<ActivityLog> findAllPagedActivity(int page, int size);
}
