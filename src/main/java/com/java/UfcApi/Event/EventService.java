package com.java.UfcApi.Event;

import jdk.jfr.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repository;
    private final EventMapper mapper;

    public EventService(EventRepository repository, EventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public EventDTO save(EventDTO event) {
        EventModel newEvent = this.repository.save(mapper.map(event));
        return mapper.map(newEvent);
    }

    public List<EventResponseDTO> listAll() {
        return repository.findAll().stream().map(mapper::mapToResponse).toList();
    }

    public EventResponseDTO listById(Long id) {
        return repository.findById(id)
                .map(mapper::mapToResponse)
                .orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public EventDTO update(Long id, EventDTO newEvent) {
        return repository.findById(id)
                .map(event -> {
                    event.setName(newEvent.name());
                    event.setEventType(newEvent.eventType());
                    event.setEventDate(newEvent.eventDate());

                    EventModel eventModel = repository.save(event);
                    return mapper.map(eventModel);
                }).orElseThrow(() -> new IllegalStateException("Event not found"));
    }
}
