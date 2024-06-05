package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.FonctionCentral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionCentralRepository extends JpaRepository<FonctionCentral, Long> {
    @Query("select distinct f.libelle from FonctionCentral f where f.fc = ?1")
    List<String> findLibelleByFc(boolean b);
    @Query("select DISTINCT u.etablissement from Utilisateur u where u.codeUo not in(select f.libelle from FonctionCentral f where f.fc = true)")
    List<String> findAllNotInFc();

}
