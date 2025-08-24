package com.java.UfcApi.Fighter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FighterService {

    private final FighterRepository repository;
    private final FighterMapper mapper;

    public FighterService(FighterRepository repository, FighterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FighterModel save(FighterDTO fighterDTO) {
        FighterModel newFighter = mapper.map(fighterDTO);
        return this.repository.save(newFighter);
    }

    public List<FighterDTO> listAll() {
        List<FighterModel> fighters = this.repository.findAll();
        return fighters.stream()
                .map(mapper::map)
                .toList();
    }

    public FighterDTO listById(Long id) {
        Optional<FighterModel> fighter = this.repository.findById(id);
        return fighter.map(mapper::map).orElse(null);
    }

    public void delete(Long id) {
        this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));
        this.repository.deleteById(id);
    }

    public FighterDTO update(Long id, FighterDTO fighterDTO) {
        return repository.findById(id)
                .map(fighter -> {
                    fighter.setName(fighterDTO.name());
                    fighter.setCpf(fighterDTO.cpf());
                    fighter.setNickname(fighterDTO.nickname());
                    fighter.setWeight(fighterDTO.weight());
                    fighter.setHeight(fighterDTO.height());
                    fighter.setWeightDivision(fighterDTO.weightDivision());
                    fighter.setNumberVictory(fighterDTO.numberVictory());
                    fighter.setNumberLose(fighterDTO.numberLose());
                    fighter.setNumberDraw(fighterDTO.numberDraw());
                    this.repository.save(fighter);
                    return this.mapper.map(fighter);
                }).orElseThrow(() -> {
                    return new IllegalArgumentException("Fighter not found");
                });
    }


}
