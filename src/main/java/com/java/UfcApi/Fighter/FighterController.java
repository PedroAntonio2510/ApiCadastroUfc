package com.java.UfcApi.Fighter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fighter")
public class FighterController {

    private final FighterService fighterService;

    public FighterController(FighterService fighterService) {
        this.fighterService = fighterService;
    }

    @PostMapping
    @Operation(summary = "Create a fighter")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fighter created"),
            @ApiResponse(responseCode = "400", description = "Error creating fighter")
    })
    public ResponseEntity<String> create(@RequestBody FighterDTO fighter) {
        FighterModel newFighter = fighterService.save(fighter);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fighter added sucesslly: " + newFighter.getName());
    }

    @GetMapping
    @Operation(summary = "List all fighters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Show the fighters"),
    })
    public ResponseEntity<List<FighterDTO>> list() {
        List<FighterDTO> fighters = fighterService.listAll();
        return ResponseEntity.ok(fighters);
    }

    @GetMapping("/{id}")
    @Operation(summary = "List a fighter by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter found"),
            @ApiResponse(responseCode = "404", description = "Fighter not found")
    })
    public ResponseEntity<FighterDTO> listById(@PathVariable Long id) {
        FighterDTO figherId = fighterService.listById(id);
        return ResponseEntity.ok(figherId);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a fighter by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fighter updated"),
            @ApiResponse(responseCode = "404", description = "Fighter not found")
    })
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody FighterDTO fighterDTO) {
        fighterService.update(id, fighterDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Fighter updated sucessfully");

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a fighter by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fighter deleted"),
            @ApiResponse(responseCode = "404", description = "Fighter not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fighterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
