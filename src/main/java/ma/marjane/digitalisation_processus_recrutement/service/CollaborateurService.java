package ma.marjane.digitalisation_processus_recrutement.service;

import ma.marjane.digitalisation_processus_recrutement.dto.CollaborateurDto;

import java.util.Optional;
import java.util.UUID;

public interface CollaborateurService {

    CollaborateurDto save(CollaborateurDto collaborateurDto);

//    CollaborateurDto update(CollaborateurDto collaborateurDto);

    void deleteById(UUID id);
}
