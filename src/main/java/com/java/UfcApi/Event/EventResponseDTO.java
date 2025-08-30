package com.java.UfcApi.Event;

import com.java.UfcApi.Fight.FightDTO;
import com.java.UfcApi.Fight.FightModel;

import java.time.LocalDate;
import java.util.List;

public record EventResponseDTO(
        String name,
        String eventType,
        LocalDate eventDate,
        List<com.java.UfcApi.Fight.FightDTO> fights
) {
}
