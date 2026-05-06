package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.events.AccommodationRentedEvent;
import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.model.dto.AccomodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import finki.ukim.mk.lab_1_b.repository.AccommodationRepository;
import finki.ukim.mk.lab_1_b.repository.AccommodationSpecification;
import finki.ukim.mk.lab_1_b.repository.AccommodationViewRepository;
import finki.ukim.mk.lab_1_b.service.domain.AccommodationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final AccommodationViewRepository accommodationViewRepository;
    private final ApplicationEventPublisher eventPublisher;
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, AccommodationViewRepository accommodationViewRepository, ApplicationEventPublisher eventPublisher) {
        this.accommodationRepository = accommodationRepository;
        this.accommodationViewRepository = accommodationViewRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Accommodation create(Accommodation accommodation) {
        return accommodationRepository.save(accommodation);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id)
                .map(a->{
                    a.setName(accommodation.getName());
                    a.setHost(accommodation.getHost());
                    a.setCategory(accommodation.getCategory());
                    a.setNumRooms(accommodation.getNumRooms());
                    return accommodationRepository.save(a);
                });
    }

    @Override
    public Optional<Accommodation> deleteById(Long id) {
        Optional<Accommodation>accommodation=accommodationRepository.findById(id);
        accommodation.ifPresent(accommodationRepository::delete);
        return accommodation;
    }

    @Override
    public Optional<Accommodation> booked(Long id) {
        Accommodation acc = accommodationRepository.findById(id)
                .orElseThrow();

        acc.setNumRooms(acc.getNumRooms() - 1);

        accommodationRepository.save(acc);

        eventPublisher.publishEvent(
                new AccommodationRentedEvent(
                        acc.getId(),
                        acc.getNumRooms()
                )
        );

        return accommodationRepository.findById(id)
                .map(a->{
                    a.setNumRooms(a.getNumRooms()==0 ? 0 : a.getNumRooms()-1);
                    return accommodationRepository.save(a);
                });
    }

    @Override
    public Page<AccomodationDto> findAll(String category, Long hostId, String countryName, Integer numRooms, Boolean hasFree,int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Specification<Accommodation> spec = Specification.where((Specification<Accommodation>) null);

        if (category != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("category"), category));
        }
        if (hostId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("host").get("id"), hostId));
        }
        if (countryName != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("host").get("country").get("name"), countryName));
        }
        if (numRooms != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("numRooms"), numRooms));
        }

        if (hasFree != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("hasFree"), hasFree));
        }


        return accommodationRepository.findAll(pageable).map(this::toDto);

    }


    public Page<AccomodationDto> findAllPaged(
            int page,
            int size,
            String sortBy,
            String sortDir,
            String category,
            String host,
            String country,
            Integer rooms,
            Boolean isFree
    ) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Accommodation> spec =
                AccommodationSpecification.filter(
                        category,
                        host,
                        country,
                        rooms,
                        isFree
                );

        return accommodationRepository.findAll(spec, pageable)
                .map(this::toDto);
    }

    @Override
    public Optional<AccommodationProjection> findByIdWithProjection(Long id) {
        return accommodationRepository.findByIdWithProjection(id);
    }

    @Override
    public List<AccommodationView> findAllFromView() {
        return accommodationViewRepository.findAll();
    }

    @Override
    public List<AccommodationStatsProjection> getStats() {
        return accommodationRepository.findStats();
    }

    @Override
    public List<Accommodation> findNewest() {
        return accommodationRepository.findTop5Newest();
    }


    private AccomodationDto toDto(Accommodation accommodation) {
        return new AccomodationDto(
                accommodation.getName(),
                accommodation.getCreatedAt(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getHost().getCountry(),
                accommodation.getNumRooms(),
                accommodation.getAccommodationState()
        );
    }

}
