package ma.marjane.digitalisation_processus_recrutement.mapper.impl;

import ma.marjane.digitalisation_processus_recrutement.dto.CandidatDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Candidate;
import ma.marjane.digitalisation_processus_recrutement.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapperImpl implements BaseMapper<Candidate, CandidatDto> {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Candidate convertToEntity(CandidatDto candidateDto) {
        return modelMapper.map(candidateDto, Candidate.class);
    }

    @Override
    public CandidatDto convertToDto(Candidate candidateEntity) {
        return modelMapper.map(candidateEntity, CandidatDto.class);
    }
}
