package finki.ukim.mk.lab_1_b.model.projection;

public interface AccommodationProjection {
    Long getId();
    String getName();
    String getCategory();
    Integer getNumRooms();

    String getHostName();
    String getHostSurname();
    String getHostCountry();
}
