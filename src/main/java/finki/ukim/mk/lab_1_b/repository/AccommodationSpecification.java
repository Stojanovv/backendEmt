package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AccommodationSpecification {
    public static Specification<Accommodation> filter(
            String category,
            String host,
            String country,
            Integer rooms,
            Boolean hasFreeRooms
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (category != null) {
                predicates.add(cb.equal(root.get("category"), category));
            }

            if (host != null) {
                predicates.add(cb.equal(root.get("host").get("id"), host));
            }

            if (country != null) {
                predicates.add(cb.equal(root.get("host").get("country").get("name"), country));
            }

            if (rooms != null) {
                predicates.add(cb.equal(root.get("numRooms"), rooms));
            }

            if (hasFreeRooms != null) {
                if (hasFreeRooms) {
                    predicates.add(cb.greaterThan(root.get("numRooms"), 0));
                } else {
                    predicates.add(cb.equal(root.get("numRooms"), 0));
                }
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
