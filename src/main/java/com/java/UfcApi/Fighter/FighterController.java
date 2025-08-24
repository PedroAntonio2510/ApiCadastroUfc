package com.java.UfcApi.Fighter;

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
    public ResponseEntity<String> create(@RequestBody FighterDTO fighter) {
        FighterModel newFighter = fighterService.save(fighter);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fighter added sucesslly: " + newFighter.getName());
    }

    @GetMapping
    public ResponseEntity<List<FighterDTO>> list() {
        List<FighterDTO> fighters = fighterService.listAll();
        return ResponseEntity.ok(fighters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FighterDTO> listById(@PathVariable Long id) {
        FighterDTO figherId = fighterService.listById(id);
        return ResponseEntity.ok(figherId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody FighterDTO fighterDTO) {
        fighterService.update(id, fighterDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Fighter updated sucessfully");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        fighterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
