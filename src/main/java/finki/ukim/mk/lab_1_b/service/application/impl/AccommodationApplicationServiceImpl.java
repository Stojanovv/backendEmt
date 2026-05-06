package finki.ukim.mk.lab_1_b.service.application.impl;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.model.dto.AccomodationDto;
import finki.ukim.mk.lab_1_b.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab_1_b.model.exeption.HostNotFoundExeption;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import finki.ukim.mk.lab_1_b.service.application.AccommodationApplicationService;
import finki.ukim.mk.lab_1_b.service.domain.AccommodationService;
import finki.ukim.mk.lab_1_b.service.domain.HostService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto cad) {
        Host host = hostService.findById(cad.host_id())
                .orElseThrow(() -> new HostNotFoundExeption(cad.host_id()));

        return accommodationService.update(id,cad.toAccommodation(host))
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto cad) {
        Host host = hostService.findById(cad.host_id())
                .orElseThrow(() -> new HostNotFoundExeption(cad.host_id()));

        return DisplayAccommodationDto.from(accommodationService.create(cad.toAccommodation(host)));
    }

    @Override
    public Optional<DisplayAccommodationDto> deleteById(Long id) {
        return accommodationService.deleteById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> booked(Long id) {
        return accommodationService.booked(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Page<AccomodationDto> findAllPaged(int page, int size, String sortBy, String sortDir, String category, String host, String country, Integer rooms, Boolean isFree) {
        return accommodationService.findAllPaged(page, size, sortBy, sortDir, category, host, country, rooms, isFree);
    }

    @Override
    public Optional<AccommodationProjection> findByIdWithProjection(Long id) {
        return accommodationService.findByIdWithProjection(id);
    }

    @Override
    public List<AccommodationView> findAllFromView() {
        return accommodationService.findAllFromView();
    }

    @Override
    public List<AccommodationStatsProjection> getStats() {
        return accommodationService.getStats();
    }

    @Override
    public List<Accommodation> findTop5Newest() {
        return accommodationService.findNewest();
    }


}
