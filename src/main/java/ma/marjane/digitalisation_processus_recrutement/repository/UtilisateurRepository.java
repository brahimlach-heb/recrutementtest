package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Utilisateur findByMail(String mail);

    Utilisateur findByMatricule(String matricule);
    @Query("SELECT DISTINCT u.societe FROM Utilisateur u where u.societe is not null")
    List<String> findAllBySociete();



}

