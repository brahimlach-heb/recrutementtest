package ma.marjane.digitalisation_processus_recrutement.controller;

import ma.marjane.digitalisation_processus_recrutement.dto.HierarchieDTO;
import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;
import ma.marjane.digitalisation_processus_recrutement.service.impl.HierarchieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hierarchies")
public class HierarchieController {
    @Autowired
    private HierarchieService hierarchieService;

    @GetMapping
    public List<HierarchieDTO> getAllHierarchies() {
        return hierarchieService.getAllHierarchies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<HierarchieDTO>> getHierarchieById(@PathVariable UUID id) {
        List<HierarchieDTO> hierarchieDTOS = hierarchieService.getHierarchieById(id);
        if (hierarchieDTOS != null && !hierarchieDTOS.isEmpty()) {
            return ResponseEntity.ok(hierarchieDTOS);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/valider/{id}/{matricule}")
    public boolean validerdemande(@PathVariable UUID id, @PathVariable String matricule) {
        return hierarchieService.validerdemande(id, matricule);
    }


//    @PostMapping
//    public HierarchieDTO createHierarchie(@RequestBody HierarchieDTO hierarchieDTO) {
//        return hierarchieService.createHierarchie(hierarchieDTO);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<HierarchieDTO> updateHierarchie(@PathVariable UUID id, @RequestBody HierarchieDTO hierarchieDTO) {
//        HierarchieDTO updatedHierarchieDTO = hierarchieService.updateHierarchie(id, hierarchieDTO);
//        if (updatedHierarchieDTO != null) {
//            return ResponseEntity.ok(updatedHierarchieDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
    @GetMapping("/demandes/{matricule}")
    public List<Collaborateur> getdemandes(@PathVariable String matricule) {
        return hierarchieService.getdemandes(matricule);
    }
    @PostMapping("/refuser/{id}/{matricule}/{commentaire}")
    public boolean refuserdemande(@PathVariable UUID id, @PathVariable String commentaire, @PathVariable String matricule) {
        return hierarchieService.refuserdemande(id,matricule, commentaire);
    }

}
