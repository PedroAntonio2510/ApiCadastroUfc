package com.java.UfcApi.Fighter;

import org.springframework.stereotype.Component;

@Component
public class FighterMapper {

    public FighterModel map(FighterDTO fighterDTO) {
        FighterModel fighterModel = new FighterModel();
        fighterModel.setName(fighterDTO.name());
        fighterModel.setNickname(fighterDTO.nickname());
        fighterModel.setWeight(fighterDTO.weight());
        fighterModel.setHeight(fighterDTO.height());
        fighterModel.setWeightDivision(fighterDTO.weightDivision());
        fighterModel.setNumberVictory(fighterDTO.numberVictory());
        fighterModel.setNumberLose(fighterDTO.numberLose());
        fighterModel.setNumberDraw(fighterDTO.numberDraw());

        return fighterModel;
    }

}
