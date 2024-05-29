package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.UtilisateurMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import ma.marjane.digitalisation_processus_recrutement.service.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImp {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private UtilisateurMapperImpl utilisateurMapper;

    public UtilisateurDto getUserDTOByEmail(String mail) {
        Utilisateur utilisateur = utilisateurRepository.findByMail(mail);
        return utilisateurMapper.convertToDto(utilisateur);
    }
    public String getDemandeur(String matricule) {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        return utilisateur.getNom() + " " + utilisateur.getPrenom();
    }
}
