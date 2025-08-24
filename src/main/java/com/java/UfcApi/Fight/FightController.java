package com.java.UfcApi.Fight;

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
    public ResponseEntity<String> save(@RequestBody CreateFightDTO fightDTO) {
        FightDTO fight = fightService.save(fightDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Fight confirmed:  " + fight.fighterBlueCorner().name() + " x " + fight.fighterRedCorner().name());
    }

    @GetMapping
    public ResponseEntity<List<FightDTO>> list() {
        List<FightDTO> fights = fightService.listAll();
        return ResponseEntity.ok(fights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listById(@PathVariable Long id) {
        return fightService.listById(id)
                .map(fightDTO -> ResponseEntity.ok(fightDTO))
                .orElse(ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,
                                         @RequestBody FightDTO newFight) {
        FightDTO fight = fightService.update(id, newFight);
        return ResponseEntity.ok("Fight updated: " + fight.fighterRedCorner().name() + " x " + fight.fighterBlueCorner().name());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        fightService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

