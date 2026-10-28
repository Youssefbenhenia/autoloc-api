package tn.esprit.autoloc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;
import java.math.BigDecimal;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository vehiculeRepository) {
        return args -> {

            if (vehiculeRepository.count() == 0) {

                Vehicule v1 = new Vehicule();
                v1.setImmatriculation("123 TUN 4567");
                v1.setMarque("Renault");
                v1.setModele("Clio");
                v1.setCategorie(CategorieVehicule.CITADINE);
                v1.setTarifJournalier(new BigDecimal("80.00"));
                v1.setStatut(StatutVehicule.DISPONIBLE);

                Vehicule v2 = new Vehicule();
                v2.setImmatriculation("234 TUN 5678");
                v2.setMarque("Peugeot");
                v2.setModele("308");
                v2.setCategorie(CategorieVehicule.BERLINE);
                v2.setTarifJournalier(new BigDecimal("120.00"));
                v2.setStatut(StatutVehicule.DISPONIBLE);

                Vehicule v3 = new Vehicule();
                v3.setImmatriculation("345 TUN 6789");
                v3.setMarque("Toyota");
                v3.setModele("RAV4");
                v3.setCategorie(CategorieVehicule.SUV);
                v3.setTarifJournalier(new BigDecimal("180.00"));
                v3.setStatut(StatutVehicule.DISPONIBLE);

                vehiculeRepository.save(v1);
                vehiculeRepository.save(v2);
                vehiculeRepository.save(v3);

                System.out.println("=== Véhicules de démonstration insérés ===");
            }
        };
    }
}
