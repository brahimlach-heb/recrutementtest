package ma.marjane.digitalisation_processus_recrutement.service.impl;


import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.UtilisateurMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


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
    public UtilisateurDto getDemandeur(String matricule)  {
        Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);
        return utilisateurMapper.convertToDto(utilisateur);
    }
}
