package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.FonctionCentral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionCentralRepository extends JpaRepository<FonctionCentral, Long> {

}
