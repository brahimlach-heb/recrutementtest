package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.TacheDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Tache;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.TacheMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.TacheRepository;
import ma.marjane.digitalisation_processus_recrutement.service.TacheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TacheServiceImp implements TacheService {

    private final TacheRepository tacheRepository;
    private final TacheMapperImpl tacheMapper;

    public List<TacheDto> findAll() {
        return tacheRepository.findAll().stream().map(tacheMapper::convertToDto).toList();
    }

    public Optional<TacheDto> findById(UUID id) {
        Optional<Tache> optionalTache = tacheRepository.findById(id);
        return  optionalTache.map(tacheMapper::convertToDto);
    }

    public TacheDto save(TacheDto tacheDto) {
        tacheRepository.save(tacheMapper.convertToEntity(tacheDto));
        return tacheDto;
    }

//    public TacheDto update(TacheDto tacheDto) {
//        Optional<TacheDto> optionalTacheDto = this.findById(tacheDto.getId());
//        if (optionalTacheDto.isPresent()) {
//            tacheRepository.save(tacheMapper.convertToEntity(tacheDto));
//            return tacheDto;
//        } else {
//            // Handle case when candidate with given id is not found
//            throw new RuntimeException("Tache with id " + tacheDto.getId() + " not found");
//        }
//    }

    public void deleteById(UUID id) {
        tacheRepository.deleteById(id);
    }
}
