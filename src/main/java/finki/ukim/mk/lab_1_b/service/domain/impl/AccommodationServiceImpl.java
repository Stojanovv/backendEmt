package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.repository.AccommodationRepository;
import finki.ukim.mk.lab_1_b.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
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
        return accommodationRepository.findById(id)
                .map(a->{
                    a.setNumRooms(a.getNumRooms()==0 ? 0 : a.getNumRooms()-1);
                    return accommodationRepository.save(a);
                });
    }
}
