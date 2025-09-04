package com.java.UfcApi.Fight;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fight")
public class FightController {

    private final FightService fightService;

    public FightController(FightService fightService) {
        this.fightService = fightService;
    }

    @PostMapping
    @Operation(summary = "Create a Fight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fight created"),
            @ApiResponse(responseCode = "400", description = "Error creating fight")
    })
    public ResponseEntity<String> save(@RequestBody CreateFightDTO fightDTO) {
        FightDTO fight = fightService.save(fightDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Fight confirmed:  " + fight.fighterBlueCorner().name() + " x " + fight.fighterRedCorner().name());
    }

    @GetMapping
    @Operation(summary = "List all fight")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fights listed")
    })
    public ResponseEntity<List<FightDTO>> list() {
        List<FightDTO> fights = fightService.listAll();
        return ResponseEntity.ok(fights);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List a fight by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fight found"),
            @ApiResponse(responseCode = "404", description = "Fight not found")
    })
    public ResponseEntity<?> listById(@PathVariable Long id) {
        return fightService.listById(id)
                .map(fightDTO -> ResponseEntity.ok(fightDTO))
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a fighter by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fight updated"),
            @ApiResponse(responseCode = "404", description = "Fight not found")
    })
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody UpdateFightDTO newFight) {
        FightDTO fight = fightService.update(id, newFight);
        return ResponseEntity.ok("Fight updated: " + fight.fighterRedCorner().name() + " x " + fight.fighterBlueCorner().name());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a fight by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fight deleted"),
            @ApiResponse(responseCode = "404", description = "Fight not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fightService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

