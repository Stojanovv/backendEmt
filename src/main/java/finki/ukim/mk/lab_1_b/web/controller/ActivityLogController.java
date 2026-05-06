package finki.ukim.mk.lab_1_b.web.controller;


import finki.ukim.mk.lab_1_b.model.domain.ActivityLog;
import finki.ukim.mk.lab_1_b.service.domain.ActivityLogService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {
    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ActivityLog> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return service.findAllPagedActivity(page, size);
    }
}
