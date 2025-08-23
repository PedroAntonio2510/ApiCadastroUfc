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

}
