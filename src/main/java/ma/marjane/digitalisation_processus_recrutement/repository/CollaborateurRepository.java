package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CollaborateurRepository extends JpaRepository<Collaborateur, UUID> {
    List<Collaborateur> findByMatriculeAndAttributes(String matricule, boolean attributes);
    List<Collaborateur> findByAttributes(boolean attributes);
    List<Collaborateur> findByMatricule(String matricule);

}
