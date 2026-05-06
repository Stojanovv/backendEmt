package finki.ukim.mk.lab_1_b.model.projection;

public interface AccommodationViewProjection {
    Long getId();

    String getName();

    String getCategory();

    Integer getNumRooms();

    String getHostFullName();

    String getCountryName();
}
