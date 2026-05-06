package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.Country;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationCategory;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationState;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record AccomodationDto(
        String name,
        LocalDateTime cratedAt,
        AccommodationCategory category,
        Long host,
        Country country,
        int numRooms,
        AccommodationState isAvelable
) {
    public static AccomodationDto from(Accommodation accommodation) {
        return new AccomodationDto(
                accommodation.getName(),
                accommodation.getCreatedAt(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getHost().getCountry(),
                accommodation.getNumRooms(),
                accommodation.getAccommodationState()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> a) {
        return a.stream().map(DisplayAccommodationDto::from)
                .collect(Collectors.toList());
    }
}
