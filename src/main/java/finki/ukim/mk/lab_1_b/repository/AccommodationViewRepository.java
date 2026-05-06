package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationViewRepository
        extends JpaRepository<AccommodationView, Long> {
}
