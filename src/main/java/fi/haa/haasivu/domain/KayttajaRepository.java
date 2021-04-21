package fi.haa.haasivu.domain;

import org.springframework.data.repository.CrudRepository;


// Käyttäjäluokan reposiroty, jolla metodina käyttäjän etsiminen käyttäjänimen perusteella
public interface KayttajaRepository extends CrudRepository<Kayttaja, Long> { 
	
	Kayttaja findByUsername(String username); 

}
