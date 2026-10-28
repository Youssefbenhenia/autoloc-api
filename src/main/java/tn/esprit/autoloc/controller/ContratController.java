package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@RequestMapping("/contrats")
@RequiredArgsConstructor
public class ContratController {

    private final IContratService contratService;

    @GetMapping
    public List<Contrat> getAllContrats() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public Contrat getContrat(@PathVariable Long id) {
        return contratService.retrieveContrat(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contrat addContrat(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/{id}")
    public Contrat updateContrat(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return contratService.updateContrat(contrat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeContrat(@PathVariable Long id) {
        contratService.removeContrat(id);
    }
}