package com.java.UfcApi.Fighter;

import org.springframework.stereotype.Component;

@Component
public class FighterMapper {

    public FighterModel map(FighterDTO fighterDTO) {
        if (fighterDTO == null) {
            return null;
        }
        FighterModel fighterModel = new FighterModel();
        fighterModel.setName(fighterDTO.name());
        fighterModel.setCpf(fighterDTO.cpf());
        fighterModel.setNickname(fighterDTO.nickname());
        fighterModel.setWeight(fighterDTO.weight());
        fighterModel.setHeight(fighterDTO.height());
        fighterModel.setWeightDivision(fighterDTO.weightDivision());
        fighterModel.setNumberVictory(fighterDTO.numberVictory());
        fighterModel.setNumberLose(fighterDTO.numberLose());
        fighterModel.setNumberDraw(fighterDTO.numberDraw());

        return fighterModel;
    }

    public FighterDTO map(FighterModel fighterModel) {
        if (fighterModel == null) {
            return null;
        }
        return new FighterDTO(
                fighterModel.getName(),
                fighterModel.getCpf(),
                fighterModel.getNickname(),
                fighterModel.getWeight(),
                fighterModel.getHeight(),
                fighterModel.getWeightDivision(),
                fighterModel.getNumberVictory(),
                fighterModel.getNumberLose(),
                fighterModel.getNumberDraw()
        );
    }

}
