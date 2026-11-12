package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.EmployeRepository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final AgenceRepository agenceRepository;


    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveEmploye(Long idEmploye) {
        return employeRepository.findById(idEmploye)
                .orElseThrow(() -> new IllegalArgumentException("Employe introuvable : " + idEmploye));
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        if (employe.getIdEmploye() == null || !employeRepository.existsById(employe.getIdEmploye())) {
            throw new IllegalArgumentException("Employe introuvable : " + employe.getIdEmploye());
        }
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long idEmploye) {
        employeRepository.deleteById(idEmploye);
    }

    @Override
    @Transactional
    public Employe desaffecterEmploye(Long idEmploye) {
        Employe employe = retrieveEmploye(idEmploye);
        employe.setAgence(null);
        return employeRepository.save(employe);
    }

    @Override
    @Transactional
    public Employe affecterEmploye(Long idEmploye, Long idAgence) {
        Employe employe = retrieveEmploye(idEmploye);
        Agence agence = agenceRepository.findById(idAgence)
                .orElseThrow(() -> new IllegalArgumentException("Agence introuvable : " + idAgence));
        if (employe.getAgence() != null) {
            throw new IllegalStateException("L'employé " + idEmploye + " est déjà affecté à l'agence "
                    + employe.getAgence().getIdAgence() + ". Désaffectez-le d'abord.");
        }
        employe.setAgence(agence);
        return employeRepository.save(employe);
    }
}