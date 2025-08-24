package com.java.UfcApi.Fight;

import org.springframework.stereotype.Component;

@Component
public class FightMapper {

    public FightModel map(FightDTO dto) {
        if (dto == null) {
            return null;
        }

        FightModel entity = new FightModel();
        entity.setEvent(dto.event());
        entity.setFighterRedCorner(dto.fighterRedCorner());
        entity.setFighterBlueCorner(dto.fighterBlueCorner());
        entity.setFighterWinner(dto.fighterWinner());
        entity.setMethodWin(dto.methodWin());
        entity.setRoundFinal(dto.roundFinal());
        entity.setTimeFinal(dto.timeFinal());

        return entity;
    }

    public FightDTO map(FightModel entity) {
        if (entity == null) {
            return null;
        }

        return new FightDTO(
                entity.getEvent(),
                entity.getFighterRedCorner(),
                entity.getFighterBlueCorner(),
                entity.getFighterWinner(),
                entity.getMethodWin(),
                entity.getRoundFinal(),
                entity.getTimeFinal()
        );
    }
}
