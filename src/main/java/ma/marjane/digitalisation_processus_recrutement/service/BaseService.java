package ma.marjane.digitalisation_processus_recrutement.service;

import java.util.List;
import java.util.Optional;

public interface BaseService <T, ID>{

    List<T> findAll();

    Optional<T> findById(ID id) ;

    T save(T dto) ;

//    T update(T dto) ;

    void deleteById(ID id) ;
}
