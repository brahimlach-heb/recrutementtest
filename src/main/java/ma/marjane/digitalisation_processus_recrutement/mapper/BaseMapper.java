package ma.marjane.digitalisation_processus_recrutement.mapper;

public interface BaseMapper <ENTITY, DTO>{

    ENTITY convertToEntity(DTO dto);
    DTO convertToDto(ENTITY entity);
}
