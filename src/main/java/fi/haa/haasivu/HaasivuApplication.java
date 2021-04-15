package fi.haa.haasivu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haa.haasivu.domain.Vieras;
import fi.haa.haasivu.domain.VierasRepo;



@SpringBootApplication
public class HaasivuApplication {

	private static final Logger log = LoggerFactory.getLogger(HaasivuApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HaasivuApplication.class, args);
	} 
	
	@Bean
	public CommandLineRunner vierasEsim(VierasRepo repo) {
		return (args) -> {
			log.info("save a couple of books");
			
			
			repo.save(new Vieras(1L, "Essi", "Esimerkki", "Kyllä", "kasvis"));  
				
		/*	Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);*/
			
			log.info("fetch all books");
			for (Vieras vieras : repo.findAll()) {
				log.info(vieras.toString());
			}

		};
	}

}
