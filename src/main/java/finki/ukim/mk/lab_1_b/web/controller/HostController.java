package finki.ukim.mk.lab_1_b.web.controller;

import finki.ukim.mk.lab_1_b.model.dto.CreateHostDto;
import finki.ukim.mk.lab_1_b.model.dto.DisplayHostDto;
import finki.ukim.mk.lab_1_b.model.dto.HostStatsDto;
import finki.ukim.mk.lab_1_b.service.application.HostApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
public class HostController {
    private final HostApplicationService hostApplicationService;

    public HostController(HostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayHostDto>> findAll(){
        return ResponseEntity.ok(hostApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id){
        return hostApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayHostDto> create (@RequestBody CreateHostDto createHostDto){
        return ResponseEntity.ok(hostApplicationService.create(createHostDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayHostDto>update(@PathVariable Long id,
                                                @RequestBody CreateHostDto createHostDto){
        return hostApplicationService.update(id,createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayHostDto> delete(@PathVariable Long id){
        return hostApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/stats/{id}")
    public ResponseEntity<HostStatsDto> getStats(@PathVariable Long id){
        return ResponseEntity.ok(hostApplicationService.getStats(id));
    }
}
