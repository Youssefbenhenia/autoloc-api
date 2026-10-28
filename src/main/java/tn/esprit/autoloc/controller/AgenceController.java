package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@RequestMapping("/agences")
@RequiredArgsConstructor
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping
    public List<Agence> getAllAgences() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
    public Agence getAgence(@PathVariable Long id) {
        return agenceService.retrieveAgence(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Agence addAgence(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
    public Agence updateAgence(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return agenceService.updateAgence(agence);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAgence(@PathVariable Long id) {
        agenceService.removeAgence(id);
    }
}