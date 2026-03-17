package finki.ukim.mk.lab_1_b.service.application.impl;

import finki.ukim.mk.lab_1_b.model.dto.CreateCountryDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayCountryDto;
import finki.ukim.mk.lab_1_b.service.application.CountryApplicationSevice;
import finki.ukim.mk.lab_1_b.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationSeviceImpl implements CountryApplicationSevice {
    private final CountryService countryService;

    public CountryApplicationSeviceImpl(CountryService countryService) {
        this.countryService = countryService;
    }


    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id)
                .map(DisplayCountryDto::from);
    }

    @Override
    public DisplayCountryDto create(CreateCountryDto createCountryDto) {
        return DisplayCountryDto.from(countryService.create(createCountryDto.toCountry()));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.update(
                id,createCountryDto.toCountry()
        ).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> deleteById(Long id) {
        return countryService.deleteById(id)
                .map(DisplayCountryDto::from);
    }
}
