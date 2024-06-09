package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.record.NomPrenomMatricule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {

    Utilisateur findByMail(String mail);

    Utilisateur findByMatricule(String matricule);
    @Query("SELECT DISTINCT u.societe FROM Utilisateur u where u.societe is not null")
    List<String> findAllBySociete();

    @Query("SELECT DISTINCT u.uo FROM Utilisateur u where u.uo is not null and u.manager1= ?1")
    List<String> findAllUO(String matricule);


    @Query("SELECT new ma.marjane.digitalisation_processus_recrutement.record.NomPrenomMatricule(u.nom, u.prenom, u.matricule) FROM Utilisateur u where u.direction = ?1")
    List<NomPrenomMatricule> findAllNomPrenomMatricule(String direction);


}

