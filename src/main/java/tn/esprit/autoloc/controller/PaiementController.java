package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@RequestMapping("/paiements")
@RequiredArgsConstructor
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping
    public List<Paiement> getAllPaiements() {
        return paiementService.retrieveAllPaiements();
    }

    @GetMapping("/{id}")
    public Paiement getPaiement(@PathVariable Long id) {
        return paiementService.retrievePaiement(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        return paiementService.addPaiement(paiement);
    }

    @PutMapping("/{id}")
    public Paiement updatePaiement(@PathVariable Long id, @RequestBody Paiement paiement) {
        paiement.setIdPaiement(id);
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removePaiement(@PathVariable Long id) {
        paiementService.removePaiement(id);
    }
}