package finki.ukim.mk.lab_1_b.service.domain;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import jdk.jfr.Category;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    Optional<Accommodation>findById(Long id);
    List<Accommodation>findAll();
    Accommodation create(Accommodation accommodation);
    Optional<Accommodation>update(Long id,Accommodation accommodation);
    Optional<Accommodation>deleteById(Long id);
    Optional<Accommodation> booked(Long id);
}
