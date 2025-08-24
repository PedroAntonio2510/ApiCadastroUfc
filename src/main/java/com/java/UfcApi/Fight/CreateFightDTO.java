package com.java.UfcApi.Fight;

public record CreateFightDTO(
        Long eventId,
        Long fighterRedCornerId,
        Long fighterBlueCornerId
) {
}
