package com.java.UfcApi.Event;

import java.time.LocalDate;

public record EventDTO(
        String name,
        String eventType,
        LocalDate eventDate
) {
}
