package com.java.UfcApi.Event;

import com.java.UfcApi.Fight.FightMapper;
import com.java.UfcApi.Fight.FightModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapper {

    private final FightMapper fightMapper;

    public EventMapper(FightMapper fightMapper) {
        this.fightMapper = fightMapper;
    }

    public EventModel map(EventDTO dto) {
        if (dto == null) {
            return null;
        }
        EventModel eventModel = new EventModel();
        eventModel.setName(dto.name());
        eventModel.setEventType(dto.eventType());
        eventModel.setEventDate(dto.eventDate());
        eventModel.setFights(dto.fights().stream()
                .map(fightMapper::map)
                .toList());

        return eventModel;
    }

    public EventDTO map(EventModel model) {
        EventDTO eventDTO = new EventDTO(
                model.getName(),
                model.getEventType(),
                model.getEventDate(),
                model.getFights().stream()
                        .map(fightMapper::map)
                        .toList()
        );
        return eventDTO;
    }
}
