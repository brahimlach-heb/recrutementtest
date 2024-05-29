package ma.marjane.digitalisation_processus_recrutement.mapper.impl;

import ma.marjane.digitalisation_processus_recrutement.dto.UtilisateurDto;
import ma.marjane.digitalisation_processus_recrutement.entity.Utilisateur;
import ma.marjane.digitalisation_processus_recrutement.mapper.BaseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapperImpl implements BaseMapper<Utilisateur, UtilisateurDto> {

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Utilisateur convertToEntity(UtilisateurDto utilisateurDto) {
        return modelMapper.map(utilisateurDto, Utilisateur.class);
    }

    @Override
    public UtilisateurDto convertToDto(Utilisateur utilisateur) {
        return modelMapper.map(utilisateur, UtilisateurDto.class);
    }
}
