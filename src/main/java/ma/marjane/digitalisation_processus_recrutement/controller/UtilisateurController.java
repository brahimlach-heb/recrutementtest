package ma.marjane.digitalisation_processus_recrutement.controller;



import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.ListRH;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.UtilisateurMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.record.NomPrenomMatricule;
import ma.marjane.digitalisation_processus_recrutement.repository.ListRHRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import ma.marjane.digitalisation_processus_recrutement.service.impl.UtilisateurServiceImp;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Collections;


@RestController
@RequestMapping("/login")
public class UtilisateurController {

    @Autowired
    private UtilisateurServiceImp utilisateurService;

    @Autowired
    private ListRHRepository ListRHRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private UtilisateurMapperImpl utilisateurMapper;

    @PostMapping("/authenticate")
    public UtilisateurDto authenticate(@RequestParam String mail) throws Exception {
        UtilisateurDto utilisateurDTO = utilisateurService.getUserDTOByEmail(mail);
        // Vous pouvez ajouter ici des vérifications ou des traitements supplémentaires si nécessaire
        ListRH listRH = ListRHRepository.findByMatricule(utilisateurDTO.getMatricule());
        if (utilisateurDTO == null) {
            throw new RuntimeException("Utilisateur non trouvé");
        }else if (listRH != null){
            utilisateurDTO.setRole("RH");
        }
        else
            utilisateurDTO.setRole("Manager");
        return utilisateurDTO;
    }

//    @PostMapping("/demandeur/{matricule}")
//    public UtilisateurDto getDemandeur(@PathVariable String matricule){
//        return utilisateurService.getDemandeur(matricule);
//
//    }
    @GetMapping("/Demandeur/{matricule}")
    public UtilisateurDto getdemandeur(@PathVariable String matricule) {
        Utilisateur utilisateur =utilisateurRepository.findByMatricule(matricule);
        return utilisateurMapper.convertToDto(utilisateur);
    }

    @GetMapping("/demandeur/listeUo")
    public List<String> getUO(@RequestParam String matricule) {
        try {
            Utilisateur utilisateur = utilisateurRepository.findByMatricule(matricule);

            if (utilisateur == null) {
                // Si aucun utilisateur n'est trouvé avec ce matricule, retourner une liste vide
                return Collections.emptyList();
            }

            // Récupérer la liste des unités organisationnelles du manager 1 de l'utilisateur
            return utilisateurRepository.findAllUO(utilisateur.getManager1());

        } catch (Exception e) {
            e.printStackTrace(); // Gérer l'exception ou journaliser le problème
            return Collections.emptyList(); // Retourner une liste vide en cas d'exception
        }
    }
    @GetMapping("/demandeur/liste_nom_prenom_matricule")
    public List<NomPrenomMatricule> getNomPrenomMatricule(@RequestParam String matricule) {
        Utilisateur utilisateur =utilisateurRepository.findByMatricule(matricule);
        Utilisateur utilisateur2 =utilisateurRepository.findByMatricule(utilisateur.getManager1());
        return utilisateurRepository.findAllNomPrenomMatricule(utilisateur2.getDirection().trim());
    }






}

