package com.java.UfcApi.Fight;

import com.java.UfcApi.Fighter.FighterMapper;
import org.springframework.stereotype.Component;

@Component
public class FightMapper {

    private final FighterMapper fighterMapper;

    public FightMapper(FighterMapper fighterMapper) {
        this.fighterMapper = fighterMapper;
    }

    public FightModel map(FightDTO dto) {
        if (dto == null) {
            return null;
        }

        FightModel entity = new FightModel();
        entity.setEvent(dto.event());
        entity.setFighterRedCorner(fighterMapper.map(dto.fighterRedCorner()));
        entity.setFighterBlueCorner(fighterMapper.map(dto.fighterBlueCorner()));
        entity.setFighterWinner(fighterMapper.map(dto.fighterWinner()));
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
                fighterMapper.map(entity.getFighterRedCorner()),
                fighterMapper.map(entity.getFighterBlueCorner()),
                fighterMapper.map(entity.getFighterWinner()),
                entity.getMethodWin(),
                entity.getRoundFinal(),
                entity.getTimeFinal()
        );
    }
}
