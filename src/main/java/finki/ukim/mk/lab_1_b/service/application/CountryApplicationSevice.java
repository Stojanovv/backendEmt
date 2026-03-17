package finki.ukim.mk.lab_1_b.service.application;

import finki.ukim.mk.lab_1_b.model.dto.CreateCountryDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationSevice {
    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    DisplayCountryDto create(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> deleteById(Long id);
}
