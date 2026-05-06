package finki.ukim.mk.lab_1_b.web.controller;

import finki.ukim.mk.lab_1_b.model.domain.Accommodation;
import finki.ukim.mk.lab_1_b.model.domain.AccommodationView;
import finki.ukim.mk.lab_1_b.model.dto.AccomodationDto;
import finki.ukim.mk.lab_1_b.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayHostDto;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationProjection;
import finki.ukim.mk.lab_1_b.model.projection.AccommodationStatsProjection;
import finki.ukim.mk.lab_1_b.service.application.AccommodationApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodation")
public class AccommodationController {
    private final AccommodationApplicationService accommodationApplicationService;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService) {
        this.accommodationApplicationService = accommodationApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayAccommodationDto>>findAll(){
        return ResponseEntity.ok(accommodationApplicationService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id){
        return accommodationApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayAccommodationDto> create(@RequestBody CreateAccommodationDto createAccommodationDto){
        return ResponseEntity.ok(accommodationApplicationService.create(createAccommodationDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayAccommodationDto> update (@PathVariable Long id,
                                                           @RequestBody CreateAccommodationDto createAccommodationDto){
        return accommodationApplicationService.update(id,createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayAccommodationDto> deleteById(@PathVariable Long id){
        return accommodationApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/booked/{id}")
    public ResponseEntity<DisplayAccommodationDto> booked(@PathVariable Long id){
        return accommodationApplicationService.booked(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("/paged")
    public Page<AccomodationDto> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,

            @RequestParam(required = false) String category,
            @RequestParam(required = false) String host,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) Integer rooms,
            @RequestParam(required = false) Boolean hasFreeRooms
    ) {

        return accommodationApplicationService.findAllPaged(page, size, sortBy, sortDir,category, host, country, rooms, hasFreeRooms);
    }

    @GetMapping("/projection/{id}")
    public ResponseEntity<AccommodationProjection> findByIdWithProjection(@PathVariable Long id){
        return accommodationApplicationService.findByIdWithProjection(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/view")
    public List<AccommodationView> getViewData() {
        return accommodationApplicationService.findAllFromView();
    }

    @GetMapping("/stats")
    public List<AccommodationStatsProjection> getStats() {
        return accommodationApplicationService.getStats();
    }

    @GetMapping("/newest")
    public List<Accommodation> getNewest(){
        return accommodationApplicationService.findTop5Newest();
    }
}
