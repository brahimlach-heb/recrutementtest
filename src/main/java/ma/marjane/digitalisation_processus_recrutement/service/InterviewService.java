package ma.marjane.digitalisation_processus_recrutement.service;

import ma.marjane.digitalisation_processus_recrutement.dto.InterviewDto;

import java.util.Optional;
import java.util.UUID;

public interface InterviewService extends BaseService<InterviewDto, UUID>{

    Optional<InterviewDto> findById(UUID id);

    InterviewDto save(InterviewDto interviewDto);

//    InterviewDto update(InterviewDto interviewDto);

    void deleteById(UUID id);
}
