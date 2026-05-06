package finki.ukim.mk.lab_1_b.service.application;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import finki.ukim.mk.lab_1_b.model.dto.AccomodationDto;
import finki.ukim.mk.lab_1_b.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {
    List<DisplayAccommodationDto> findAll();
    Optional<DisplayAccommodationDto>findById(Long id);
    Optional<DisplayAccommodationDto>update(Long id, CreateAccommodationDto cad);
    DisplayAccommodationDto create (CreateAccommodationDto cad);
    Optional<DisplayAccommodationDto> deleteById(Long id);
    Optional<DisplayAccommodationDto> booked(Long id);

    Page<AccomodationDto> findAllPaged(
            int page,
            int size,
            String sortBy,
            String sortDir,
            String category,
            String host,
            String country,
            Integer rooms,
            Boolean isFree
    );

    Optional<AccommodationProjection>findByIdWithProjection(Long id);
    List<AccommodationView> findAllFromView();
    List<AccommodationStatsProjection> getStats();

    List<Accommodation> findTop5Newest();
}
