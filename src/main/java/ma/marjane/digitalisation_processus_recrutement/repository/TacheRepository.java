package ma.marjane.digitalisation_processus_recrutement.repository;

import ma.marjane.digitalisation_processus_recrutement.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TacheRepository extends JpaRepository<Tache, UUID> {
}
