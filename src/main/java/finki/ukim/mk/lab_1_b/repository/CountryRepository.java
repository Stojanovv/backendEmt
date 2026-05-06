package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
