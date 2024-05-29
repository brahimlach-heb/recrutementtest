package ma.marjane.digitalisation_processus_recrutement.service;

import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;

import java.util.Optional;

public interface UtilisateurService extends BaseService<UtilisateurDto, String>{

    Optional<UtilisateurDto> findById(String id);

    UtilisateurDto save(UtilisateurDto utilisateurDto);

//    UtilisateurDto update(UtilisateurDto utilisateurDto);

    void deleteById(String id);
}