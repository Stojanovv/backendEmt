package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationCategory;

public record CreateAccommodationDto (
        String name,
        AccommodationCategory category,
        Long host_id,
        Integer numRooms
){
    public Accommodation toAccommodation(Host host){
        return new Accommodation(name,category,host,numRooms);
    }
}
