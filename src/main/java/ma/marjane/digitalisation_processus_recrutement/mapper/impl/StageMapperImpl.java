package ma.marjane.digitalisation_processus_recrutement.mapper.impl;

import ma.marjane.digitalisation_processus_recrutement.dto.StageDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Stage;
import ma.marjane.digitalisation_processus_recrutement.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StageMapperImpl implements BaseMapper<Stage, StageDto> {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Stage convertToEntity(StageDto stageDto) {
        return modelMapper.map(stageDto, Stage.class);
    }

    @Override
    public StageDto convertToDto(Stage stage) {
        return modelMapper.map(stage, StageDto.class);
    }
}
