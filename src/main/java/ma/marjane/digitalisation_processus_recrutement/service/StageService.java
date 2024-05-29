package ma.marjane.digitalisation_processus_recrutement.service;

import ma.marjane.digitalisation_processus_recrutement.dto.StageDto;

import java.util.Optional;
import java.util.UUID;

public interface StageService extends BaseService<StageDto, UUID>{

    Optional<StageDto> findById(UUID id);

    StageDto save(StageDto stageDto);

//    StageDto update(StageDto stageDto);

    void deleteById(UUID id);
}
