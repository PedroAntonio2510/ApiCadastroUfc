package com.java.UfcApi.Fighter;

import java.util.List;

public record FighterDTO(
        String name,
        String nickname,
        Double weight,
        Double height,
        String weightDivision,
        int numberVictory,
        int numberLose,
        int numberDraw
) {
}