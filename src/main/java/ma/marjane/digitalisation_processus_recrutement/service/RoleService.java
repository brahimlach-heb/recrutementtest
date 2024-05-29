package ma.marjane.digitalisation_processus_recrutement.service;

import ma.marjane.digitalisation_processus_recrutement.dto.RoleDto;

import java.util.Optional;
import java.util.UUID;

public interface RoleService extends BaseService<RoleDto, UUID>{

    Optional<RoleDto> findById(UUID id);

    RoleDto save(RoleDto roleDto);

//    RoleDto update(RoleDto roleDto);

    void deleteById(UUID id);
}
