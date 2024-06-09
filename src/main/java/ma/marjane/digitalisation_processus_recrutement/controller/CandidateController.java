package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.CandidatDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Candidate;
import ma.marjane.digitalisation_processus_recrutement.service.impl.CandidateServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateServiceImp candidateServiceImp;


    @PostMapping("/upload")
    public ResponseEntity<Candidate> uploadCandidat(@RequestParam String nom,
                                                   @RequestParam String prenom,
                                                   @RequestParam String email,
                                                   @RequestParam String telephone,
                                                   @RequestParam MultipartFile cv,
                                                   @RequestParam UUID demandeId) throws IOException {
        Candidate candidat = new Candidate();
        candidat.setNom(nom);
        candidat.setPrenom(prenom);
        candidat.setEmail(email);
        candidat.setTelephone(telephone);
        Candidate savedCandidat = candidateServiceImp.saveCandidat(candidat, cv, demandeId);
        return ResponseEntity.ok(savedCandidat);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CandidatDto> updateCandidate(@Valid @RequestBody CandidatDto candidateDto) {
//        CandidatDto updatedCandidateDto = candidateServiceImp.update(candidateDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedCandidateDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable UUID id) {
        candidateServiceImp.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
