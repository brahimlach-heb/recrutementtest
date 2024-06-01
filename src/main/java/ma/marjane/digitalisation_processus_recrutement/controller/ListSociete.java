package ma.marjane.digitalisation_processus_recrutement.controller;

import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListSociete {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/listsociete")
    public List<String> listSociete() {
        return utilisateurRepository.findAllBySociete();
    }
}
