package finki.ukim.mk.lab_1_b.web.controller;

import finki.ukim.mk.lab_1_b.model.dto.CreateCountryDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayCountryDto;
import finki.ukim.mk.lab_1_b.service.application.CountryApplicationSevice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryApplicationSevice countryApplicationSevice;

    public CountryController(CountryApplicationSevice countryApplicationSevice) {
        this.countryApplicationSevice = countryApplicationSevice;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll(){
        return ResponseEntity.ok(countryApplicationSevice.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id){
        return countryApplicationSevice.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(@RequestBody CreateCountryDto createCountryDto){
        return ResponseEntity.ok(countryApplicationSevice.create(createCountryDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id,
                                                    @RequestBody CreateCountryDto createCountryDto){
        return countryApplicationSevice.update(id,createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayCountryDto> deleteById(@PathVariable Long id){
        return countryApplicationSevice.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
