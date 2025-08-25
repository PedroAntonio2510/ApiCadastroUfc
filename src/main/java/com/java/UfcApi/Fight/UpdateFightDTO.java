package com.java.UfcApi.Fight;

public record UpdateFightDTO(
        Long eventId,
        Long fighterRedCornerId,
        Long fighterBlueCornerId,
        Long fighterWinnerId,
        String methodWin,
        int roundFinal,
        String timeFinal
) {
}
