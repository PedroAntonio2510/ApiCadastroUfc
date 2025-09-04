package com.java.UfcApi.Event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Create a new ufc event")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Event created sucessfully"),
        @ApiResponse(responseCode = "400", description = "Error creating")
    })
    public ResponseEntity<String> save(@RequestBody EventDTO eventDTO) {
        EventDTO newEvent = service.save(eventDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event with name " + newEvent.name() + " created");
    }

    @GetMapping
    @Operation(summary = "List all events")
    @ApiResponse(responseCode = "200", description = "Events listed sucessfully")
    public ResponseEntity<List<EventResponseDTO>> listAll() {
        List<EventResponseDTO> events = service.listAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List a event by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event found"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public ResponseEntity<EventResponseDTO> listById(@PathVariable Long id) {
        EventResponseDTO event = service.listById(id);
        if (event != null) {
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a event by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event updated"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @RequestBody EventDTO eventDTO) {
        EventDTO updatedEvent = service.update(id, eventDTO);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a event by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Event deleted"),
            @ApiResponse(responseCode = "404", description = "Event not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
