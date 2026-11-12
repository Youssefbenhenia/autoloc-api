package tn.esprit.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@RequestMapping("/employes")
@RequiredArgsConstructor
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping
    public List<Employe> getAllEmployes() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public Employe getEmploye(@PathVariable Long id) {
        return employeService.retrieveEmploye(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employe addEmploye(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping("/{id}")
    public Employe updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return employeService.updateEmploye(employe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmploye(@PathVariable Long id) {
        employeService.removeEmploye(id);
    }

    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }
    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}