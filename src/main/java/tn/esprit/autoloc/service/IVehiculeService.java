package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();

    Vehicule retrieveVehicule(Long idVehicule);

    Vehicule addVehicule(Vehicule vehicule);

    Vehicule updateVehicule(Vehicule vehicule);

    void removeVehicule(Long idVehicule);

    Vehicule affecterVehicule(Long idVehicule, Long idAgence);

    Vehicule affecterEquipement(Long idVehicule, Long idEquipement);

    Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement);
}