package finki.ukim.mk.lab_1_b.service.application.impl;

import finki.ukim.mk.lab_1_b.model.domain.Country;
import finki.ukim.mk.lab_1_b.model.dto.CreateHostDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayHostDto;
import finki.ukim.mk.lab_1_b.model.exeption.CountryNotFoundExeption;
import finki.ukim.mk.lab_1_b.service.application.HostApplicationService;
import finki.ukim.mk.lab_1_b.service.domain.CountryService;
import finki.ukim.mk.lab_1_b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {
    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id)
                .map(DisplayHostDto::from);
    }

    @Override
    public DisplayHostDto create(CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.country_id())
                .orElseThrow(() -> new CountryNotFoundExeption(createHostDto.country_id()));

        return DisplayHostDto.from(hostService.create(createHostDto.toHost(country)));
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Country country = countryService.findById(createHostDto.country_id())
                .orElseThrow(() -> new CountryNotFoundExeption(createHostDto.country_id()));

        return hostService
                .update(id,createHostDto.toHost(country))
                .map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> deleteById(Long id) {
        return hostService.deleteById(id)
                .map(DisplayHostDto::from);
    }
}
