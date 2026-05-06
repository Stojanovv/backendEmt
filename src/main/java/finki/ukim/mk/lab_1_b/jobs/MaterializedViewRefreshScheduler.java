package finki.ukim.mk.lab_1_b.jobs;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final EntityManager entityManager;

    public MaterializedViewRefreshScheduler(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Scheduled(fixedRateString = "${app.mv.refresh-rate:60000}")
    @Transactional
    public void refreshMV() {
        entityManager.createNativeQuery(
                "REFRESH MATERIALIZED VIEW accommodation_stats_by_category"
        ).executeUpdate();
    }
}
