package br.com.trier.petshop.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import br.com.trier.petshop.BaseTests;
import br.com.trier.petshop.domain.EmployeeUser;
import br.com.trier.petshop.domain.Race;
import br.com.trier.petshop.services.exceptions.IntegrityViolation;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

public class RaceServiceTest extends BaseTests{
	
	@Autowired
	RaceService raceService;
	
	@Test
	@DisplayName("Teste busca por ID")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void findByIdTest() {
		var race = raceService.findById(1);
		assertNotEquals(race, null);
		assertEquals(1, race.getId());
		assertEquals("Brazillian Street Dog", race.getRaceName());		
	}
	
	@Test
	@DisplayName("Teste busca por ID inválido")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void findNotValidIdTest() {
		var exception = assertThrows(ObjectNotFound.class,	() -> raceService.findById(10));
		assertEquals("Nenhuma raça encontrada com esse id 10", exception.getMessage());
	}
	
	@Test
	@DisplayName("Teste listar todos")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void listAllTest() {
		List<Race> lista = raceService.listAll();
		assertEquals(4, lista.size());
		assertEquals(1, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Teste incluir raça")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	void insertRaceTest() {
		var race = new Race(null, "Rottweiler");
		raceService.save(race);
		race = raceService.findById(1);
		assertNotEquals(race, null);
		assertEquals(1, race.getId());
		assertEquals("Rottweiler", race.getRaceName());
	}
	
	@Test
	@DisplayName("Teste deleta raça")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void deleteRaceTest() {
		raceService.delete(1);
		List<Race> lista  = raceService.listAll();
		assertEquals(3, lista.size());
		assertEquals(2, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Busca nome da raça ")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void findByNameTest() {
		List<Race> lista = raceService.findByRaceName("Brazillian Street Dog");
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("Busca nome da raça que inicia com ")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void startWithTest() {
		List<Race> lista = raceService.findByRaceNameStartingWithIgnoreCase("b");
		assertEquals(2, lista.size());
		lista = raceService.findByRaceNameStartingWithIgnoreCase("Brazillian");
		assertEquals(2, lista.size());
	}
	
	@Test
	@DisplayName("Busca nome da raça que inicia com ")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void containsTest() {
		List<Race> lista = raceService.findByRaceNameContainsIgnoreCase("dog");
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("Cadastra raça nula")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void insertNullRaceTest() {
		var race = new Race(null, null);
		var exception = assertThrows(IntegrityViolation.class, ()-> raceService.save(race));
		assertEquals("A descrição da raça não pode ser nula!", exception.getMessage());
	}
	
	@Test
	@DisplayName("Alterar raça inexistente")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void updateNonexistentRaceTest() {
		var race = new Race(6, "Chiauau");
		var exception = assertThrows(ObjectNotFound.class,	() -> raceService.findById(6));
		assertEquals("Nenhuma raça encontrada com esse id 6", exception.getMessage());
	}
	
	@Test
	@DisplayName("Teste alterar raça")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/raca.sql")
	void updateUserTest() {
		var race = new Race(2, "Chow Chow");
		raceService.update(race);
		var alteredRace = raceService.findById(2);
		assertNotEquals(race, null);
		assertEquals(2, race.getId());
		assertEquals("Chow Chow", race.getRaceName());
	}

}
