package finki.ukim.mk.lab_1_b.model.dto;

import finki.ukim.mk.lab_1_b.model.enums.AccommodationState;

import java.util.Map;

public record HostStatsDto
        (
                long totalAccommodations,
                Map<String, Long> cond
        ){}

