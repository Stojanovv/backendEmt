package finki.ukim.mk.lab_1_b.repository;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.dto.RoomInfoDto;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation,Long>, JpaSpecificationExecutor<Accommodation> {

    List<Accommodation> findAllByHost_Id(Long id);

    @Query("""
    SELECT a.id as id,
           a.name as name,
           a.category as category,
           a.numRooms as numRooms,
           h.name as hostName,
           h.surname as hostSurname,
           c.name as hostCountry
    FROM Accommodation a
    JOIN a.host h
    JOIN h.country c
    WHERE a.id = :id
""")
    Optional<AccommodationProjection> findByIdWithProjection(@Param("id") Long id);

    @EntityGraph(value = "Accommodation.host-country")
    Optional<Accommodation> findById(Long id);

    @EntityGraph(value = "Accommodation.host-country")
    List<Accommodation> findAll();


    @Query(value = """
    SELECT
        category AS category,
        total_accommodations AS totalAccommodations,
        total_rooms AS totalRooms,
        avg_rooms AS avgRooms
    FROM accommodation_stats_by_category
""", nativeQuery = true)
    List<AccommodationStatsProjection> findStats();

    @Query("SELECT a FROM Accommodation a ORDER BY a.date_opened DESC LIMIT 5")
    List<Accommodation> findTop5Newest();
}
