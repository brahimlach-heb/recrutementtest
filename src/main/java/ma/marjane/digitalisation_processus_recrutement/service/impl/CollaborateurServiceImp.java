package ma.marjane.digitalisation_processus_recrutement.service.impl;

import lombok.RequiredArgsConstructor;
import ma.marjane.digitalisation_processus_recrutement.dto.CollaborateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Collaborateur;
import ma.marjane.digitalisation_processus_recrutement.entity.Hierarchie;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.impl.CollaborateurMapperImpl;
import ma.marjane.digitalisation_processus_recrutement.repository.CollaborateurRepository;
import ma.marjane.digitalisation_processus_recrutement.repository.UtilisateurRepository;
import ma.marjane.digitalisation_processus_recrutement.service.CollaborateurService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CollaborateurServiceImp implements CollaborateurService {


    private final CollaborateurRepository collaborateurRepository;
    private final CollaborateurMapperImpl collaborateurMapper;
    private final UtilisateurRepository utilisateurRepository;

    public List<CollaborateurDto> findAll() {

        return collaborateurRepository.findByAttributes(true).stream().map(collaborateurMapper::convertToDto).toList();
    }

    public List<CollaborateurDto> findByMatricule(String matricule) {
        List<Collaborateur> collaborateurOptional = collaborateurRepository.findByMatricule(matricule);
        return collaborateurOptional.stream().map(collaborateurMapper::convertToDto).toList();
    }

    public CollaborateurDto save(CollaborateurDto collaborateurDto) {
        Collaborateur collaborateur = collaborateurMapper.convertToEntity(collaborateurDto);
        Utilisateur utilisateur= utilisateurRepository.findByMatricule(collaborateurDto.getMatricule());
        Utilisateur manager1= utilisateurRepository.findByMatricule(utilisateur.getManager1());
        collaborateur.getHierarchies().add(Hierarchie.builder()
                .demandeId(collaborateur.getId())
                .matricule(manager1.getMatricule())
                .nom(manager1.getNom())
                .prenom(manager1.getPrenom())
                .datedecreation(new Date())
                .statut("En cours")
                .build());
        collaborateurRepository.save(collaborateur);
        return collaborateurDto;
    }

//    public CollaborateurDto update(CollaborateurDto collaborateurDto) {
//        Optional<CollaborateurDto> optionalCollaborateurDto = this.findById(collaborateurDto.getId());
//        if (optionalCollaborateurDto.isPresent()) {
//            collaborateurRepository.save(collaborateurMapper.convertToEntity(collaborateurDto));
//            return collaborateurDto;
//        }else {
//            // Handle case when candidate with given id is not found
//            throw new RuntimeException("Demande Collaborateur with id " + collaborateurDto.getId() + " not found");
//        }
//    }

    public void deleteById(UUID id) {
        collaborateurRepository.deleteById(id);
    }
}
