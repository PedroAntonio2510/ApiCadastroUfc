package com.java.UfcApi.Fight;

import com.java.UfcApi.Event.EventModel;
import com.java.UfcApi.Fighter.FighterDTO;
import com.java.UfcApi.Fighter.FighterModel;

// TODO: Alterar o fighterWinner para retonar apenas o nome do vencedor

public record FightDTO(
        EventModel event,
        FighterDTO fighterRedCorner,
        FighterDTO fighterBlueCorner,
        FighterDTO fighterWinner,
        String methodWin,
        int roundFinal,
        String timeFinal
) {

}
