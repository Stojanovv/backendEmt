package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationCategory;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto (
        Long id,
        String name,
        AccommodationCategory category,
        Long host_id,
        Integer num
){
    public static DisplayAccommodationDto from(Accommodation accommodation){
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getNumRooms()
        );
    }

    public static List<DisplayAccommodationDto>from(List<Accommodation>a){
        return a.stream().map(DisplayAccommodationDto::from)
                .collect(Collectors.toList());
    }
}
