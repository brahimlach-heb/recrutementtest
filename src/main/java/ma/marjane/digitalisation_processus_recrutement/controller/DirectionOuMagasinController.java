package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.DirectionOuMagasinDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.DirectionOuMagasinServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/direction-ou-magasins")
public class DirectionOuMagasinController {

    private final DirectionOuMagasinServiceImp directionOuMagasinService;

    @GetMapping
    public ResponseEntity<List<DirectionOuMagasinDto>> getAllDirectionOuMagasins() {
        List<DirectionOuMagasinDto> directionOuMagasins = directionOuMagasinService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(directionOuMagasins);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DirectionOuMagasinDto> getDirectionOuMagasinById(@PathVariable UUID id) {
        return directionOuMagasinService.findById(id)
                .map(directionOuMagasinDto -> ResponseEntity.status(HttpStatus.OK).body(directionOuMagasinDto))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DirectionOuMagasinDto> createDirectionOuMagasin(@Valid @RequestBody DirectionOuMagasinDto directionOuMagasinDto) {
        DirectionOuMagasinDto createdDirectionOuMagasinDto = directionOuMagasinService.save(directionOuMagasinDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirectionOuMagasinDto);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<DirectionOuMagasinDto> updateDirectionOuMagasin(@Valid @RequestBody DirectionOuMagasinDto directionOuMagasinDto) {
//        DirectionOuMagasinDto updatedDirectionOuMagasinDto = directionOuMagasinService.update(directionOuMagasinDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedDirectionOuMagasinDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirectionOuMagasin(@PathVariable UUID id) {
        directionOuMagasinService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
