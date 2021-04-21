package fi.haa.haasivu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haa.haasivu.domain.EiTulevatRepo;
import fi.haa.haasivu.domain.EiVieras;
import fi.haa.haasivu.domain.Kayttaja;
import fi.haa.haasivu.domain.KayttajaRepository;
import fi.haa.haasivu.domain.Vieras;
import fi.haa.haasivu.domain.VierasRepo;



@SpringBootApplication
public class HaasivuApplication {

	private static final Logger log = LoggerFactory.getLogger(HaasivuApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HaasivuApplication.class, args);
	} 
	
	@Bean
	public CommandLineRunner vierasEsim(VierasRepo repo, KayttajaRepository kayttajaRepo, EiTulevatRepo eiTulevatRepo) {
		return (args) -> {
			
			// luodaan sivulle yksi esimerkki vieras
			repo.save(new Vieras(1L, "Essi", "Esimerkki", "Kyllä", "kasvis"));   
			repo.save(new Vieras(2L, "Jarmo", "Tahvainen", "Kyllä", "Kaikki käy")); 
			repo.save(new Vieras(3L, "Hemuli", "Örn", "Kyllä", "Ei ole preferenssejä")); 
			eiTulevatRepo.save(new EiVieras(4L, "Helmi", "Örn", "Ei"));
			
			// luodaan sivulle kaksi eri käyttäjää: admin/admin user/user
			Kayttaja user1 = new Kayttaja("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			Kayttaja user2 = new Kayttaja("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			kayttajaRepo.save(user1);
			kayttajaRepo.save(user2);
			
			//tarkistetaan konsolissa että vieraat ovat tallentuneet repoon
			log.info("vieraat");
			for (Vieras vieras : repo.findAll()) {
				log.info(vieras.toString());
			}   
			//tarkistetaan konsolissa että eiVieraat ovat tallentuneet repoon
			log.info("eivieraat");
			for (EiVieras eivieras : eiTulevatRepo.findAll()) {
				log.info(eivieras.toString());
			}

		};
	}

}
