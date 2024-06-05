package ma.marjane.digitalisation_processus_recrutement.repository;


import ma.marjane.digitalisation_processus_recrutement.entity.Hierarchie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface HierarchieRepository extends JpaRepository<Hierarchie, UUID> {

    List<Hierarchie> findByMatricule(String matricule);
    List<Hierarchie> findByDemandeId(UUID demandeid);

    List<Hierarchie> findByMatriculeAndStatut( String matricule, String statut);

    List<Hierarchie> findByDemandeIdAndMatricule(UUID demandeId, String matricule);
}