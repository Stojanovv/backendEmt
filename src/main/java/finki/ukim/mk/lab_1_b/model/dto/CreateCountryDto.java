package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Country;

public record CreateCountryDto(
        String name,
        String continent
) {
    public Country toCountry(){
        return new Country(name,continent);
    }
}
