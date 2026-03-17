package finki.ukim.mk.lab_1_b.service.domain;

import finki.ukim.mk.lab_1_b.model.domain.Country;
import finki.ukim.mk.lab_1_b.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Optional<Country> findById(Long id);
    List<Country> findAll();
    Country create(Country country);
    Optional<Country>update(Long id,Country country);
    Optional<Country>deleteById(Long id);
}
