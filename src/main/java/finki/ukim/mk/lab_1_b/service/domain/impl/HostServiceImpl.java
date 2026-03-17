package finki.ukim.mk.lab_1_b.service.domain.impl;

import finki.ukim.mk.lab_1_b.model.domain.Host;
import finki.ukim.mk.lab_1_b.repository.HostRepository;
import finki.ukim.mk.lab_1_b.service.domain.HostService;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
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
}
