package br.com.trier.petshop;

import br.com.trier.petshop.services.AddressService;
import br.com.trier.petshop.services.EmployeeUserService;
import br.com.trier.petshop.services.RaceService;
import br.com.trier.petshop.services.SpeciesService;
import br.com.trier.petshop.services.impl.AddressServiceImpl;
import br.com.trier.petshop.services.impl.EmployeeUserServiceImpl;
import br.com.trier.petshop.services.impl.RaceServiceImpl;
import br.com.trier.petshop.services.impl.SpeciesServiceImpl;

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
	
	@Bean 
	public RaceService raceService() {
		return new RaceServiceImpl();
	}
	
	@Bean 
	public SpeciesService speciesServices() {
		return new SpeciesServiceImpl();
	}
	
	@Bean
	public AddressService addressService() {
		return new AddressServiceImpl();
	}
	
}
