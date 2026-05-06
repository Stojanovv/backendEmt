package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host,Long> {
}
