package fi.haa.haasivu.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Vierasrepository, ei tarvittavia ylimääräisiä metodeita, Crud-luokan metodit riittävät
public interface VierasRepo extends CrudRepository<Vieras, Long> { 
	
	//List<Vieras> findByLastName(String sukunimi);

}
