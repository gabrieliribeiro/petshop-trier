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
import br.com.trier.petshop.domain.Species;
import br.com.trier.petshop.services.exceptions.ObjectNotFound;

public class SpeciesServiceTest extends BaseTests{
	
	@Autowired
	SpeciesService speciesService;
	
	@Test
	@DisplayName("Teste busca por ID")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void findByIdTest() {
		var user = speciesService.findById(1);
		assertNotEquals(user, null);
		assertEquals(1, user.getId());
		assertEquals("Cachorro", user.getDescription());		
	}
	
	@Test
	@DisplayName("Teste busca por ID inválido")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void findNotValidIdTest() {
		var exception = assertThrows(ObjectNotFound.class,	() -> speciesService.findById(10));
		assertEquals("Nenhuma espécie encontrada com esse id 10", exception.getMessage());
	}
	
	@Test
	@DisplayName("Teste listar todos")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void listAllTest() {
		List<Species> lista = speciesService.listAll();
		assertEquals(2, lista.size());
		assertEquals(1, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Teste incluir espécie")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	void insertUserTest() {
		var especie = new Species(null, "nome");
		speciesService.save(especie);
		especie = speciesService.findById(1);
		assertNotEquals(especie, null);
		assertEquals(1, especie.getId());
		assertEquals("nome", especie.getDescription());
		
	}
	
	@Test
	@DisplayName("Teste deleta espécie")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void deleteUserTest() {
		speciesService.delete(1);
		List<Species> lista  = speciesService.listAll();
		assertEquals(1, lista.size());
		assertEquals(2, lista.get(0).getId());
	}
	
	@Test
	@DisplayName("Busca nome do usuário que inicia com ")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void startWithTest() {
		List<Species> lista = speciesService.findByDescriptionStartingWithIgnoreCase("c");
		assertEquals(1, lista.size());
		lista = speciesService.findByDescriptionStartingWithIgnoreCase("gato");
		assertEquals(1, lista.size());
	}
	
	@Test
	@DisplayName("Alterar usuário espécie inválida")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void updateNonexistentUser() {
		var especie = new Species(5, "Pagagaio");
		var exception = assertThrows(ObjectNotFound.class,	() -> speciesService.findById(5));
		assertEquals("Nenhuma espécie encontrada com esse id 5", exception.getMessage());
	}
	
	@Test
	@DisplayName("Teste alterar espécie")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void updateUserTest() {
		var especie = new Species(1, "altera");
		speciesService.update(especie);
		var alteredEspecie = speciesService.findById(1);
		assertNotEquals(especie, null);
		assertEquals(1, especie.getId());
		assertEquals("altera", especie.getDescription());
	}
	
	@Test
	@DisplayName("Busca por descrição ")
	@Sql(scripts = "classpath:sql/limpa_tabela.sql")
	@Sql(scripts = "classpath:sql/especie.sql")
	void findByDescriptionTest() {
		List<Species> lista = speciesService.findByDescription("Cachorro");
		assertEquals(1, lista.size());
	}
}
