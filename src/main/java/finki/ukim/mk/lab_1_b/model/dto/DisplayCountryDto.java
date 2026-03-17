package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayCountryDto(
        Long id,
        String name,
        String couninent
) {
    public static DisplayCountryDto from(Country country){
        return new DisplayCountryDto(
                country.getId(),
                country.getName(),
                country.getContinent()
        );
    }

    public static List<DisplayCountryDto>from(List<Country> countries){
        return countries.stream().map(DisplayCountryDto::from).collect(Collectors.toList());
    }
}
