package br.com.trier.petshop;

import br.com.trier.petshop.services.EmployeeUserService;
import br.com.trier.petshop.services.impl.EmployeeUserServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class BaseTests {
	
	@Bean
	public EmployeeUserService employeeUserService() {
		return new EmployeeUserServiceImpl();
	}
	
}
