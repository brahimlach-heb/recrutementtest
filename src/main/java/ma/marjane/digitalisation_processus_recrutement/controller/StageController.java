package ma.marjane.digitalisation_processus_recrutement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.StageDto;
import ma.marjane.digitalisation_processus_recrutement.dto.TacheDto;
import ma.marjane.digitalisation_processus_recrutement.service.impl.StageServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("Stagiaire")
@RequiredArgsConstructor
public class StageController {

    private final StageServiceImp stageService;

    @GetMapping
    public ResponseEntity<List<StageDto>> getAllStages() {
        List<StageDto> stages = stageService.findAll();
        return ResponseEntity.ok(stages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StageDto> getStageById(@PathVariable UUID id) {
        return stageService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StageDto> createStage(@RequestBody StageDto stageDto) {
        StageDto createdStage = stageService.save(stageDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStage);
    }

//    @PutMapping
//    public ResponseEntity<StageDto> updateTache(@Valid @RequestBody StageDto stageDto) {
//        StageDto updatedStageDto = stageService.update(stageDto);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedStageDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStage(@PathVariable UUID id) {
        stageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
