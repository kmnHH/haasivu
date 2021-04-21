package fi.haa.haasivu.domain;

import org.springframework.data.repository.CrudRepository;

//Ei tulevien vieraiden repository, ei tarvittavia ylimääräisiä metodeita, Crud-luokan metodit riittävät
public interface EiTulevatRepo extends CrudRepository<EiVieras, Long> {

}
