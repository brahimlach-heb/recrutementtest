package ma.marjane.digitalisation_processus_recrutement.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.ListRH;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.repository.ListRHRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import ma.marjane.digitalisation_processus_recrutement.service.impl.UtilisateurServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UtilisateurController {

    @Autowired
    private UtilisateurServiceImp utilisateurService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

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

    @GetMapping("demandeur/{matricule}")
    public ResponseEntity<Utilisateur> getDemandeur(@PathVariable String matricule) {
        return utilisateurRepository.findByMatricule(matricule) != null ? ResponseEntity.ok(utilisateurRepository.findByMatricule(matricule)) : ResponseEntity.notFound().build();
    }

}

