package finki.ukim.mk.lab_1_b.service.application;

import finki.ukim.mk.lab_1_b.model.dto.CreateHostDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {
    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> findById(Long id);

    DisplayHostDto create(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    Optional<DisplayHostDto> deleteById(Long id);
}
