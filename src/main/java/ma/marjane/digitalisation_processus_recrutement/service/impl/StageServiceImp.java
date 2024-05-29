package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.StageDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Stage;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.StageMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.StageRepository;
import ma.marjane.digitalisation_processus_recrutement.service.StageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StageServiceImp implements StageService {

    private final StageRepository stageRepository;
    private final StageMapperImpl stageMapper;

    public List<StageDto> findAll() {
        return stageRepository.findAll().stream().map(stageMapper::convertToDto).toList();
    }

    public Optional<StageDto> findById(UUID id) {
        Optional<Stage> stageOptional = stageRepository.findById(id);
        return stageOptional.map(stageMapper::convertToDto);
    }

    public StageDto save(StageDto stageDto) {
        stageRepository.save(stageMapper.convertToEntity(stageDto));
        return stageDto;
    }

//    public StageDto update(StageDto stageDto) {
//        Optional<StageDto> optionalStageDto = this.findById(stageDto.getId());
//        if (optionalStageDto.isPresent()) {
//            stageRepository.save(stageMapper.convertToEntity(stageDto));
//            return stageDto;
//
//        }else {
//            // Handle case when candidate with given id is not found
//            throw new RuntimeException("Demand Stage with id " + stageDto.getId() + " not found");
//        }
//    }

    public void deleteById(UUID id) {
        stageRepository.deleteById(id);
    }
}
