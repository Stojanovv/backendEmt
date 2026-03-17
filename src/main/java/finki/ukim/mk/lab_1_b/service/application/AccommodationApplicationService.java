package finki.ukim.mk.lab_1_b.service.application;

import finki.ukim.mk.lab_1_b.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto>findById(Long id);
    Optional<DisplayAccommodationDto>update(Long id, CreateAccommodationDto cad);
    DisplayAccommodationDto create (CreateAccommodationDto cad);
    Optional<DisplayAccommodationDto> deleteById(Long id);
    Optional<DisplayAccommodationDto> booked(Long id);
}
