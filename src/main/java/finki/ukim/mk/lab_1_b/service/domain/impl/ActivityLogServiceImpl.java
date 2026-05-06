package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.model.domain.ActivityLog;
import finki.ukim.mk.lab_1_b.repository.ActivityLogRepository;
import finki.ukim.mk.lab_1_b.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<ActivityLog> findAllPagedActivity(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}
