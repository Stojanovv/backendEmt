package finki.ukim.mk.lab_1_b.service.domain;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import finki.ukim.mk.lab_1_b.model.dto.AccomodationDto;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import jdk.jfr.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    Optional<Accommodation>findById(Long id);
    List<Accommodation>findAll();
    Accommodation create(Accommodation accommodation);
    Optional<Accommodation>update(Long id,Accommodation accommodation);
    Optional<Accommodation>deleteById(Long id);
    Optional<Accommodation> booked(Long id);


    public Page<AccomodationDto> findAll(
            String category, Long hostId, String countryName,
            Integer numRooms, Boolean hasFreeRooms, int page,int size);

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

    Optional<AccommodationProjection> findByIdWithProjection(Long id);
    List<AccommodationView> findAllFromView();

    List<AccommodationStatsProjection> getStats();

    List<Accommodation> findNewest();
}
