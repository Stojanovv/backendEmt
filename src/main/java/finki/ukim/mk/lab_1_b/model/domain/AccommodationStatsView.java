package finki.ukim.mk.lab_1_b.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "accommodation_stats_by_category")
@Immutable
public class AccommodationStatsView {

    @Id
    private String category;

    private Long totalAccommodations;
    private Long totalRooms;
    private Double avgRooms;
}