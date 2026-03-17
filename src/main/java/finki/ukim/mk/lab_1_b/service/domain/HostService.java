package finki.ukim.mk.lab_1_b.service.domain;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    Optional<Host> findById(Long id);
    List<Host> findAll();
    Host create(Host host);
    Optional<Host>update(Long id,Host host);
    Optional<Host>deleteById(Long id);
}
