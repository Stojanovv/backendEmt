package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.model.domain.Country;
import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.repository.CountryRepository;
import finki.ukim.mk.lab_1_b.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return countryRepository.findById(id)
                .map(a->{
                    a.setName(country.getName());
                    a.setContinent(country.getContinent());
                    return countryRepository.save(a);
                });
    }

    @Override
    public Optional<Country> deleteById(Long id) {
        Optional<Country>country=countryRepository.findById(id);
        country.ifPresent(countryRepository::delete);
        return country;
    }
}
