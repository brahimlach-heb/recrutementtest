package ma.marjane.digitalisation_processus_recrutement.controller;

import ma.marjane.digitalisation_processus_recrutement.entity.FonctionCentral;
import ma.marjane.digitalisation_processus_recrutement.repository.FonctionCentralRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListSocieteController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private FonctionCentralRepository fonctionCentralRepository;


    @GetMapping("/listsociete")
    public List<String> listSociete() {
        return utilisateurRepository.findAllBySociete();
    }

    @GetMapping("/listeDirection")
    public List<String> listDirection( @RequestParam String fonction) {
        if (fonction.equals("fonctioncentral"))
            return fonctionCentralRepository.findLibelleByFc(true);
        else if (fonction.equals("siege"))
            return fonctionCentralRepository.findLibelleByFc(false);
        else
            return fonctionCentralRepository.findAllNotInFc();
    }
}
