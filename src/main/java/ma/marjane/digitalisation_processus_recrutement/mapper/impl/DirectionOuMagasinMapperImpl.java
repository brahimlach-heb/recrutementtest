package ma.marjane.digitalisation_processus_recrutement.mapper.impl;

import ma.marjane.digitalisation_processus_recrutement.dto.DirectionOuMagasinDto;
import ma.marjane.digitalisation_processus_recrutement.entity.DirectionOuMagasin;
import ma.marjane.digitalisation_processus_recrutement.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DirectionOuMagasinMapperImpl implements BaseMapper<DirectionOuMagasin, DirectionOuMagasinDto> {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public DirectionOuMagasin convertToEntity(DirectionOuMagasinDto directionOuMagasinDto) {
        return modelMapper.map(directionOuMagasinDto, DirectionOuMagasin.class);
    }

    @Override
    public DirectionOuMagasinDto convertToDto(DirectionOuMagasin directionOuMagasin) {
        return modelMapper.map(directionOuMagasin, DirectionOuMagasinDto.class);
    }
}
