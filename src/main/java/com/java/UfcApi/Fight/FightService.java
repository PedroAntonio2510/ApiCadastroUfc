package com.java.UfcApi.Fight;

import com.java.UfcApi.Event.EventModel;
import com.java.UfcApi.Event.EventRepository;
import com.java.UfcApi.Fighter.FighterModel;
import com.java.UfcApi.Fighter.FighterRepository;
import org.springframework.stereotype.Service;
import com.java.UfcApi.Fight.UpdateFightDTO;

import java.util.List;
import java.util.Optional;

@Service
public class FightService {

    private final FightRepository fightRepository;
    private final EventRepository eventRepository;
    private final FighterRepository fighterRepository;
    private final FightMapper mapper;

    public FightService(FightRepository fightRepository, EventRepository eventRepository, FighterRepository fighterRepository, FightMapper mapper) {
        this.fightRepository = fightRepository;
        this.eventRepository = eventRepository;
        this.fighterRepository = fighterRepository;
        this.mapper = mapper;
    }

    public FightDTO save(CreateFightDTO createFightDTO) {
        EventModel event = this.eventRepository.findById(createFightDTO.eventId())
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));
        FighterModel fighterRed = this.fighterRepository.findById(createFightDTO.fighterRedCornerId())
                .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));
        FighterModel fighterBlue = this.fighterRepository.findById(createFightDTO.fighterBlueCornerId())
                .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));

        FightModel newFight = new FightModel();
        newFight.setEvent(event);
        newFight.setFighterRedCorner(fighterRed);
        newFight.setFighterBlueCorner(fighterBlue);

        FightModel savedFight = this.fightRepository.save(newFight);
        return mapper.map(savedFight);
    }

    public List<FightDTO> listAll() {
        return this.fightRepository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }

    public Optional<FightDTO> listById(Long id) {
        return this.fightRepository.findById(id)
                .map(mapper::map);
    }


    public void delete(Long id) {
        this.fightRepository.deleteById(id);
    }

    public FightDTO update(Long id, UpdateFightDTO newFight) {
        return this.fightRepository.findById(id)
                .map(fight -> {
                    EventModel event = this.eventRepository.findById(newFight.eventId())
                            .orElseThrow(() -> new IllegalArgumentException("Event not found"));
                    FighterModel fighterRed = this.fighterRepository.findById(newFight.fighterRedCornerId())
                            .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));
                    FighterModel fighterBlue = this.fighterRepository.findById(newFight.fighterBlueCornerId())
                            .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));

                    if (newFight.fighterWinnerId() != null) {
                        FighterModel fighterWinner = this.fighterRepository.findById(newFight.fighterWinnerId())
                                .orElseThrow(() -> new IllegalArgumentException("Fighter not found"));
                        fight.setFighterWinner(fighterWinner);
                    }

                    fight.setEvent(event);
                    fight.setFighterRedCorner(fighterRed);
                    fight.setFighterBlueCorner(fighterBlue);
                    fight.setMethodWin(newFight.methodWin());
                    fight.setRoundFinal(newFight.roundFinal());
                    fight.setTimeFinal(newFight.timeFinal());
                    FightModel updatedFight = this.fightRepository.save(fight);
                    return mapper.map(updatedFight);
                })
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Fight not found");
                });
    }
}
