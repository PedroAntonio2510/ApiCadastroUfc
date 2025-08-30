package com.java.UfcApi.Event;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody EventDTO eventDTO) {
        EventDTO newEvent = service.save(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event with name " + newEvent.name() + " created");
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> listAll() {
        List<EventResponseDTO> events = service.listAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> listById(@PathVariable Long id) {
        EventResponseDTO event = service.listById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = service.update(id, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
