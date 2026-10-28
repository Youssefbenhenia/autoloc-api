package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @GetMapping
    public List<Equipement> getAllEquipements() {
        return equipementService.retrieveAllEquipements();
    }

    @GetMapping("/{id}")
    public Equipement getEquipement(@PathVariable Long id) {
        return equipementService.retrieveEquipement(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement addEquipement(@RequestBody Equipement equipement) {
        return equipementService.addEquipement(equipement);
    }

    @PutMapping("/{id}")
    public Equipement updateEquipement(@PathVariable Long id, @RequestBody Equipement equipement) {
        equipement.setIdEquipement(id);
        return equipementService.updateEquipement(equipement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEquipement(@PathVariable Long id) {
        equipementService.removeEquipement(id);
    }
}