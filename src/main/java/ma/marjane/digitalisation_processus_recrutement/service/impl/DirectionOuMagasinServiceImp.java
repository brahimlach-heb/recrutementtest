package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.DirectionOuMagasinDto;
import ma.marjane.digitalisation_processus_recrutement.entity.DirectionOuMagasin;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.DirectionOuMagasinMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.DirectionOuMagasinRepository;
import ma.marjane.digitalisation_processus_recrutement.service.DirectionOuMagasinService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DirectionOuMagasinServiceImp implements DirectionOuMagasinService {

    private final DirectionOuMagasinRepository directionOuMagasinRepository;
    private final DirectionOuMagasinMapperImpl directionOuMagasinMapper;

    public List<DirectionOuMagasinDto> findAll() {
        return directionOuMagasinRepository.findAll().stream().map(directionOuMagasinMapper::convertToDto).toList();
    }

    public Optional<DirectionOuMagasinDto> findById(UUID id) {
        Optional<DirectionOuMagasin> candidateOptional = directionOuMagasinRepository.findById(id);
        return candidateOptional.map(directionOuMagasinMapper::convertToDto);
    }

    public DirectionOuMagasinDto save(DirectionOuMagasinDto candidateDto) {
        directionOuMagasinRepository.save(directionOuMagasinMapper.convertToEntity(candidateDto));
        return candidateDto;
    }

//    public DirectionOuMagasinDto update(DirectionOuMagasinDto directionOuMagasinDto) {
//        Optional<DirectionOuMagasinDto> optionalDirectionOuMagasinDto = this.findById(directionOuMagasinDto.getId());
//        if (optionalDirectionOuMagasinDto.isPresent()) {
//            directionOuMagasinRepository.save(directionOuMagasinMapper.convertToEntity(directionOuMagasinDto));
//            return directionOuMagasinDto;
//        } else {
//            // Handle case when candidate with given id is not found
//            throw new RuntimeException("Direction ou Magasin with id " + directionOuMagasinDto.getId() + " not found");
//        }
//    }

    public void deleteById(UUID id) {
        directionOuMagasinRepository.deleteById(id);
    }
}
