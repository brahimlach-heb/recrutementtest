package ma.marjane.digitalisation_processus_recrutement.controller;

import ma.marjane.digitalisation_processus_recrutement.entity.FonctionCentral;
import ma.marjane.digitalisation_processus_recrutement.repository.FonctionCentralRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Collections;


@RestController
public class ListSocieteController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private FonctionCentralRepository fonctionCentralRepository;


    @GetMapping("/listsociete")
    public List<String> listSociete() {
        try {
            List<String> societes = utilisateurRepository.findAllBySociete();
            // Vérifier si la liste retournée est null et la traiter
            return (societes == null) ? Collections.emptyList() : societes;
        } catch (Exception e) {
            e.printStackTrace(); // Gérer l'exception ou journaliser le problème
            return Collections.emptyList(); // Retourner une liste vide en cas d'exception
        }
    }

    @GetMapping("/listeDirection")
    public List<String> listDirection( @RequestParam String fonction,@RequestParam String societe) throws Exception {
        if (fonction.equals("fonctioncentral"))
            return fonctionCentralRepository.findLibelleByFc();
        else if (fonction.equals("siege"))
            return fonctionCentralRepository.findAllSiege(societe);
        return fonctionCentralRepository.findAllMagasin(societe);
    }
}
