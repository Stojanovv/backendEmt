package finki.ukim.mk.lab_1_b.model.projection;

public interface AccommodationStatsProjection {
    String getCategory();
    Long getTotalAccommodations();
    Long getTotalRooms();
    Double getAvgRooms();
}
