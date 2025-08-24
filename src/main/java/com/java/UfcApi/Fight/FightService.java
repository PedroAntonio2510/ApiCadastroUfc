package com.java.UfcApi.Fight;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FightService {

    private final FightRepository repository;
    private final FightMapper mapper;

    public FightService(FightRepository repository, FightMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FightDTO save(FightDTO fightDTO) {
        FightModel newFight = mapper.map(fightDTO);
        FightModel savedFight = this.repository.save(newFight);
        return mapper.map(savedFight);
    }

    public List<FightDTO> listAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    public FightDTO listById(Long id) {
        Optional<FightModel> fightFound = this.repository.findById(id);
        return fightFound.map(mapper::map).orElse(null);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public FightDTO update(Long id, FightDTO newFight) {
        return this.repository.findById(id)
                .map(fight -> {
                    fight.setEvent(newFight.event());
                    fight.setFighterRedCorner(newFight.fighterRedCorner());
                    fight.setFighterBlueCorner(newFight.fighterBlueCorner());
                    fight.setFighterWinner(newFight.fighterWinner());
                    fight.setMethodWin(newFight.methodWin());
                    fight.setRoundFinal(newFight.roundFinal());
                    fight.setTimeFinal(newFight.timeFinal());
                    FightModel updatedFight = this.repository.save(fight);
                    return mapper.map(updatedFight);
                })
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Fighter not found");
                });
    }
}
