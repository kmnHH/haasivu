package fi.haa.haasivu.domain;

import org.springframework.data.repository.CrudRepository;



public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> { 
	
	Kayttaja findByUsername(String username); 

}