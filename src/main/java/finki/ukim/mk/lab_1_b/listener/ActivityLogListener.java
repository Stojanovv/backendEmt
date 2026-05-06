package finki.ukim.mk.lab_1_b.listener;

import finki.ukim.mk.lab_1_b.events.AccommodationRentedEvent;
import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.ActivityLog;
import finki.ukim.mk.lab_1_b.repository.AccommodationRepository;
import finki.ukim.mk.lab_1_b.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class ActivityLogListener {

    private final ActivityLogRepository activityLogRepository;
    private final AccommodationRepository accommodationRepository;

    private static final Logger log =
            LoggerFactory.getLogger(ActivityLogListener.class);

    public ActivityLogListener(ActivityLogRepository activityLogRepository, AccommodationRepository accommodationRepository) {
        this.activityLogRepository = activityLogRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @EventListener
    public void onAccommodationRented(AccommodationRentedEvent event) {

        Accommodation accommodation = accommodationRepository
                .findById(event.accommodationId())
                .orElseThrow();

        ActivityLog logEntry = new ActivityLog(
                accommodation.getName(),
                LocalDateTime.now(),
                "RENTED"
        );

        activityLogRepository.save(logEntry);

        log.info("Activity log saved for accommodation: {}", accommodation.getName());
    }
}