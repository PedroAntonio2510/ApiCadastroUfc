package com.java.UfcApi.Event;

import com.java.UfcApi.Fight.FightDTO;

import java.time.LocalDate;
import java.util.List;

public record EventResponseDTO(
        String name,
        String eventType,
        LocalDate eventDate,
        List<FightDTO> fights
) {
}
