package com.java.UfcApi.Fight;

import com.java.UfcApi.Event.EventModel;
import com.java.UfcApi.Fighter.FighterModel;

public record FightDTO(
        EventModel event,
        FighterModel fighterRedCorner,
        FighterModel fighterBlueCorner,
        FighterModel fighterWinner,
        String methodWin,
        int roundFinal,
        String timeFinal
) {

}
