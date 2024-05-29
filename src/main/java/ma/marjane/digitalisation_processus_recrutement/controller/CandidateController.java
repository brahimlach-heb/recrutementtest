package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.CandidatDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.CandidateServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateServiceImp candidateServiceImp;

    @GetMapping
    public ResponseEntity<List<CandidatDto>> findAll() {
        List<CandidatDto> candidates = candidateServiceImp.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(candidates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidatDto> getCandidateById(@PathVariable UUID id) {
        return candidateServiceImp.findById(id)
                .map(candidateDto -> ResponseEntity.status(HttpStatus.OK).body(candidateDto))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CandidatDto> createCandidate(@Valid @RequestBody CandidatDto candidateDto) {
        CandidatDto savedCandidateDto = candidateServiceImp.save(candidateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCandidateDto);
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
