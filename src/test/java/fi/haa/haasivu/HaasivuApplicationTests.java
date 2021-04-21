package fi.haa.haasivu;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haa.haasivu.web.VierasController;


@RunWith(SpringRunner.class)
@SpringBootTest
class HaasivuApplicationTests { 
	
	@Autowired  
	private VierasController vcont; 

	@Test
	void contextLoads()throws Exception { 
		assertThat(vcont).isNotNull();
	}

}
