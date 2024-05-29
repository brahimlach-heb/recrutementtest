package ma.marjane.digitalisation_processus_recrutement.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.TacheDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.TacheServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/taches")
public class TacheController {

    private final TacheServiceImp tacheService;

    @GetMapping
    public ResponseEntity<List<TacheDto>> getAllTaches() {
        List<TacheDto> taches = tacheService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(taches);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TacheDto> getTacheById(@PathVariable UUID id) {
        return tacheService.findById(id)
                .map(tacheDto -> ResponseEntity.status(HttpStatus.OK).body(tacheDto))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TacheDto> createTache(@Valid @RequestBody TacheDto tacheDto) {
        TacheDto createdTacheDto = tacheService.save(tacheDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTacheDto);
    }

//    @PutMapping
//    public ResponseEntity<TacheDto> updateTache(@Valid @RequestBody TacheDto tacheDto) {
//        TacheDto updatedTacheDto = tacheService.update(tacheDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedTacheDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTache(@PathVariable UUID id) {
        tacheService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
