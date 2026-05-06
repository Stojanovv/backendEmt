package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.model.dto.HostStatsDto;
import finki.ukim.mk.lab_1_b.model.enums.AccommodationState;
import finki.ukim.mk.lab_1_b.repository.AccommodationRepository;
import finki.ukim.mk.lab_1_b.repository.HostRepository;
import finki.ukim.mk.lab_1_b.service.domain.HostService;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public HostServiceImpl(HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;

    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host create(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id)
                .map(a-> {
                    a.setName(host.getName());
                    a.setSurname(host.getSurname());
                    a.setCountry(host.getCountry());
                    return hostRepository.save(a);
                });
    }

    @Override
    public Optional<Host> deleteById(Long id) {
        Optional<Host>hosts=hostRepository.findById(id);
        hosts.ifPresent(hostRepository::delete);
        return hosts;
    }

    @Override
    public HostStatsDto getStats(Long id) {
        List<Accommodation> list = accommodationRepository.findAllByHost_Id(id);

        long total = list.size();

        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(
                        a->a.getAccommodationState().toString().equals("1") ? "GOOD" : "BAD",
                        HashMap::new,
                        Collectors.counting()
                ));

        for (AccommodationState state : AccommodationState.values()) {
            map.putIfAbsent(state.toString(), 0L);
        }

        return new HostStatsDto(total, map);
    }


}
