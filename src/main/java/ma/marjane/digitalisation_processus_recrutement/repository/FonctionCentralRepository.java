package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.FonctionCentral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionCentralRepository extends JpaRepository<FonctionCentral, Long> {
    @Query("select distinct f.libelle from FonctionCentral f where f.fc = true")
    List<String> findLibelleByFc();
    @Query("select DISTINCT u.etablissement from Utilisateur u where u.code_uo not in(select f.code_uo from FonctionCentral f) and u.societe = ?1")
    List<String> findAllMagasin(String societe);
    @Query("select DISTINCT u.direction from Utilisateur u where u.code_uo in(select f.code_uo from FonctionCentral f where f.fc=false) and u.societe = ?1")
    List<String> findAllSiege(String societe);


}
