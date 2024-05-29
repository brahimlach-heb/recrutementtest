package ma.marjane.digitalisation_processus_recrutement.mapper.impl;

import ma.marjane.digitalisation_processus_recrutement.dto.CollaborateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CollaborateurMapperImpl implements BaseMapper<Collaborateur, CollaborateurDto> {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Collaborateur convertToEntity(CollaborateurDto collaborateurDto) {
        return modelMapper.map(collaborateurDto, Collaborateur.class);
    }

    @Override
    public CollaborateurDto convertToDto(Collaborateur collaborateur) {
        return modelMapper.map(collaborateur, CollaborateurDto.class);
    }
}
