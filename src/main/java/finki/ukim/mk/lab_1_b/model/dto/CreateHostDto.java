package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.domain.Country;
import finki.ukim.mk.lab_1_b.model.domain.Host;

public record CreateHostDto(
        String name,
        String surname,
        Long country_id
) {
    public Host toHost(Country country){
        return new Host(name,surname,country);
    }
}
