package finki.ukim.mk.lab_1_b.web.controller;

import finki.ukim.mk.lab_1_b.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayHostDto;
import finki.ukim.mk.lab_1_b.service.application.AccommodationApplicationService;
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
}
