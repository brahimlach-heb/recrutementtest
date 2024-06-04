package ma.marjane.digitalisation_processus_recrutement.controller;



import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.ListRH;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.UtilisateurMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.ListRHRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import ma.marjane.digitalisation_processus_recrutement.service.impl.UtilisateurServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


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


}

